package com.movie.catalog.feign.clients;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.catalog.model.UserRating;

@FeignClient( name = "ratingClient", url = "${ratingDataServiceUrl}"/*, fallback = RatingClientFallBack.class*/ )
public interface RatingFeignClient
{
    @RequestMapping( value = "/{userId}", method = RequestMethod.GET )
    public UserRating getUserRating( @PathVariable( "userId" ) String userId );
}
