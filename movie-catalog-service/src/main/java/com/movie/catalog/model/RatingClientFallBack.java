package com.movie.catalog.model;

import java.util.Collections;

import org.springframework.stereotype.Component;

import com.movie.catalog.feign.clients.RatingFeignClient;

@Component
public class RatingClientFallBack implements RatingFeignClient
{
    @Override
    public UserRating getUserRating( String userId )
    {
        return new UserRating( "FALLBACK USER", Collections.EMPTY_LIST );
    }
}
