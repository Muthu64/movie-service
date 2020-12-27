package com.rating.endpoint;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.model.Rating;
import com.rating.model.UserRating;

@RestController
@RefreshScope
@RequestMapping( "/rating" )
public class RatingDataResource
{
    private static final Logger LOGGER = LoggerFactory.getLogger( RatingDataResource.class );

    @RequestMapping( "/movie/{movieId}" )
    public Rating getMovieRating( @PathVariable( "movieId" ) String movieId )
    {
        System.out.println( "Received request movie id: " + movieId );
        return new Rating( movieId, 5 );
    }

    @RequestMapping( "/{userId}" )
    public UserRating getUserRating( @PathVariable( "userId" ) String userId )
    {
        LOGGER.info( "movie rating service received request userId : {}", userId );

        Random random = new Random();

        List<Rating> ratings = Arrays.asList( new Rating(  String.valueOf( random.nextInt( 1000 ) ) ),
                new Rating(  String.valueOf( random.nextInt( 1000 ) ) ),
                new Rating(  String.valueOf( random.nextInt( 1000 ) ) ) );

        LOGGER.info( "movie ratings service response : {}", ratings );

        return new UserRating( userId, ratings );
    }
}
