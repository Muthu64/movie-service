package com.rating.model;

import java.util.List;
import java.util.StringJoiner;

public class UserRating
{
    private String userId;
    private List<Rating> ratings;

    public UserRating( String userId, List<Rating> ratings )
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
