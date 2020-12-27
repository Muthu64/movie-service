package com.movie.info.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.info.model.Movie;
import com.movie.info.model.MovieMessage;
import com.movie.info.proxy.MovieDbFeignClient;

@RestController
@RefreshScope
@RequestMapping( "/info" )
public class MovieInfoResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger( MovieInfoResource.class );

    @Autowired
    private MovieDbFeignClient movieDbFeignClient;

    @Value( "${movieDbApiKey}" )
    private String apiKey;

    @RequestMapping( "/{movieId}" )
    public Movie getMovieInformation( @PathVariable( "movieId" ) String movieId )
    {
        LOGGER.info( "movie info received movie id: {}", movieId );

        Movie movie = this.movieDbFeignClient.getMovieInformation( movieId, apiKey );

        LOGGER.info( "movie info movie response:", movie );
        return movie;
    }

   /* @KafkaListener( groupId = "movie-list-group", topics = "movieTopic", containerFactory = "kafkaListenerContainerFactory" )
    public void getJsonMsgFromTopic( MovieMessage movieMessage )
    {
        System.out.println( "consumed message --> " + movieMessage );
    }*/
}
