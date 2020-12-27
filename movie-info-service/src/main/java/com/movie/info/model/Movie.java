package com.movie.info.model;

import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie
{
    private String movieId;
    private String movieName;
    private String movieDescription;
    private double voteAverage;

    @JsonCreator
    public Movie( @JsonProperty( "id" ) String movieId,
                  @JsonProperty( "title" ) String movieName,
                  @JsonProperty( "overview" ) String movieDescription,
                  @JsonProperty( "vote_average" )double voteAverage )
    {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.voteAverage = voteAverage;
    }

    public String getMovieId()
    {
        return movieId;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public String getMovieDescription()
    {
        return movieDescription;
    }

    public double getVoteAverage()
    {
        return voteAverage;
    }

    @Override
    public String toString()
    {
        return new StringJoiner( ", ", Movie.class.getSimpleName() + "[", "]" ).add( "movieId='" + movieId + "'" ).add( "movieName='" + movieName + "'" ).add( "movieDescription='" + movieDescription + "'" ).toString();
    }
}
