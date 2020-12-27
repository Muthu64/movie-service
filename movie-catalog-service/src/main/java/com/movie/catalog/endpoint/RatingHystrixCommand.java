package com.movie.catalog.endpoint;

import java.util.Collections;

import com.movie.catalog.feign.clients.RatingFeignClient;
import com.movie.catalog.model.UserRating;
import com.netflix.hystrix.HystrixCommand;

public class RatingHystrixCommand extends HystrixCommand<UserRating>
{
    private RatingFeignClient ratingFeignClient;
    private String userId;

    public RatingHystrixCommand( Setter setter, RatingFeignClient ratingFeignClient, String userId )
    {
        super( setter );
        this.ratingFeignClient = ratingFeignClient;
        this.userId = userId;
    }

    @Override
    protected UserRating run() throws Exception
    {
        System.out.println( "run" );
        UserRating userRating = this.ratingFeignClient.getUserRating( userId );
        return userRating;
    }

    @Override
    protected UserRating getFallback()
    {
        System.out.println( "Fallback" );
        return new UserRating( this.userId, Collections.emptyList() );
    }
}
