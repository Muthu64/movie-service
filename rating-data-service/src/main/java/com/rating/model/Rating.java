package com.rating.model;

import java.util.StringJoiner;

public class Rating
{
    private String movieId;
    private int rating;

    public Rating( String movieId, int rating )
    {
        this.movieId = movieId;
        this.rating = rating;
    }

    public Rating( String movieId )
    {
        this.movieId = movieId;
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
