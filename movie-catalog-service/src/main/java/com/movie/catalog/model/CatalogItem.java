package com.movie.catalog.model;

public class CatalogItem
{
    private String name;
    private String description;
    private double rating;

    public CatalogItem( String name, String description, double rating )
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
