package com.movie.info.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CatalogItem
{
    private String name;
    private String description;
    private double rating;

    @JsonCreator
    public CatalogItem( @JsonProperty( "name" ) String name, @JsonProperty( "description" ) String description, @JsonProperty( "rating" ) double rating )
    {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public double getRating()
    {
        return rating;
    }

    @Override
    public String toString()
    {
        return "CatalogItem{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", rating=" + rating + '}';
    }
}
