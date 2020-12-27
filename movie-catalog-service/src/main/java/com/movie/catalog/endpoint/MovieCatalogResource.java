package com.movie.catalog.endpoint;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.catalog.configuration.RatingHystrixFactory;
import com.movie.catalog.model.CatalogItem;
import com.movie.catalog.model.ClientType;
//import com.movie.catalog.model.KafkaConfiguration;
import com.movie.catalog.model.Movie;
import com.movie.catalog.model.MovieMessage;
import com.movie.catalog.model.UserRating;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping( "/catalog" )
@RefreshScope
public class MovieCatalogResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger( MovieCatalogResource.class );

    @Autowired
    private RestTemplate restTemplate;

   /* @Autowired
    private KafkaConfiguration kafkaConfiguration;*/

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RatingHystrixFactory ratingHystrixFactory;

    @Value( "${movieInfoServiceUrl}" )
    private String movieInfoServiceUrl;

    @Value( "${ratingDataServiceUrl}" )
    private String ratingDataServiceUrl;


    @RequestMapping( value = "/{userId}", method = RequestMethod.GET )
    //@HystrixCommand(fallbackMethod = "getFallBack")
    @ApiOperation( value = "Get catalog movie list with description" )
    public List<CatalogItem> getCatalog( @PathVariable( "userId" ) String userId ) throws Exception
    {
        LOGGER.info( "user Id passed : {}", userId );
        //get all rated movie ids
        //for each movie Id call movie service to get the information
        UserRating userRating = this.getUserRating( userId, ClientType.REST_TEMPLATE );

        LOGGER.info( "user rating in catalog service : {}", userRating );
        List<CatalogItem> catalogItems = userRating.getRatings().stream().map( ratingCandidate ->
        {
            Movie movie = this.webClientBuilder.build().get().uri( this.movieInfoServiceUrl.concat( ratingCandidate.getMovieId() ) ).retrieve().bodyToMono( Movie.class ).block();
            //Movie movie = this.restTemplate.getForObject( this.movieInfoServiceUrl.concat( ratingCandidate.getMovieId() ), Movie.class );
            return new CatalogItem( movie.getMovieName(), movie.getMovieDescription(), movie.getVoteAverage() );
        } ).collect( Collectors.toList() );

        LOGGER.info( "catalog response : {}", catalogItems );
        //this.sendMessageToKafka( catalogItems );
        return catalogItems;
    }

/*
    private void sendMessageToKafka( List<CatalogItem> catalogItems )
    {
        MovieMessage movieMessage = new MovieMessage( catalogItems.get( 0 ) );
        this.kafkaConfiguration.getKafkaTemplate().send( this.kafkaConfiguration.getMovieTopic().name(), movieMessage );
    }
*/

    private UserRating getUserRating( String userId, ClientType clientType ) throws Exception
    {
        UserRating userRating = null;

        switch( clientType )
        {
            case OPEN_FEIGN:
            {
                //problem with service discovery
                RatingHystrixCommand ratingHystrixCommand = this.ratingHystrixFactory.userRatingHystrixCommand( userId );
                userRating = ratingHystrixCommand.execute();
                break;
            }
            case WEB_CLIENT:
            {
                userRating = this.webClientBuilder.build().get().uri( ratingDataServiceUrl.concat( userId ) ).retrieve().bodyToMono( UserRating.class ).block();
                break;
            }
            case REST_TEMPLATE:
            {
                userRating = this.restTemplate.getForObject( ratingDataServiceUrl.concat( userId ), UserRating.class );
                break;
            }
            default:
            {
                throw new Exception( "invalid client type" );
            }
        }
        return userRating;
    }

    public List<CatalogItem> getFallBack( @PathVariable( "userId" ) String userId )
    {
        return Collections.singletonList( new CatalogItem( "Fallback Movie", "Fallback desc", 5 ) );
    }

}

