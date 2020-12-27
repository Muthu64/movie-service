package com.movie.catalog.model;

import java.util.List;
import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRating
{
    private String userId;
    private List<Rating> ratings;

    @JsonCreator
    public UserRating( @JsonProperty( "userId" ) String userId, @JsonProperty( "ratings" ) List<Rating> ratings )
    {
        this.userId = userId;
        this.ratings = ratings;
    }

    public String getUserId()
    {
        return userId;
    }

    public List<Rating> getRatings()
    {
        return ratings;
    }

    @Override
    public String toString()
    {
        return new StringJoiner( ", ", UserRating.class.getSimpleName() + "[", "]" ).add( "userId='" + userId + "'" ).add( "ratings=" + ratings ).toString();
    }
}
