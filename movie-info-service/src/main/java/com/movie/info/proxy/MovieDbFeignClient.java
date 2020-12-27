package com.movie.info.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.movie.info.model.Movie;

@FeignClient( name = "movieDb-client", url = "${movie-db-url}", fallback = MovieDBClientFallBack.class )
public interface MovieDbFeignClient
{
    @RequestMapping( value = "/{movieId}", method = RequestMethod.GET )
    public Movie getMovieInformation( @PathVariable( "movieId" ) String movieId, @RequestParam( "api_key" ) String apiKey );
}
