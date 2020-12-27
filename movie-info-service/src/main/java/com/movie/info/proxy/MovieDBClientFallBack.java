package com.movie.info.proxy;

import org.springframework.stereotype.Component;

import com.movie.info.model.Movie;

@Component
    public class MovieDBClientFallBack implements MovieDbFeignClient
{
    @Override
    public Movie getMovieInformation( String movieId, String apiKey )
    {
        return new Movie( "FALLBACK MOVIE", "FALLBACK MOVIE", "FALLBACK MOVIE", 0.0 );
    }
}
