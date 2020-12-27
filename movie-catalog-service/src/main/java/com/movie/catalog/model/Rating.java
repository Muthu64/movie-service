package com.movie.catalog.model;

import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating
{
    private String movieId;
    private int rating;

    @JsonCreator
    public Rating( @JsonProperty( "movieId" ) String movieId, @JsonProperty( "rating" ) int rating )
    {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId()
    {
        return movieId;
    }

    public int getRating()
    {
        return rating;
    }

    @Override
    public String toString()
    {
        return new StringJoiner( ", ", Rating.class.getSimpleName() + "[", "]" ).add( "movieId='" + movieId + "'" ).add( "rating=" + rating ).toString();
    }
}
