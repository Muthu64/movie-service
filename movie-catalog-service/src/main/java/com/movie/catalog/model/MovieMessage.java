package com.movie.catalog.model;

public class MovieMessage
{
    private CatalogItem catalogItem;

    public MovieMessage( CatalogItem catalogItem )
    {
        this.catalogItem = catalogItem;
    }

    public CatalogItem getCatalogItem()
    {
        return catalogItem;
    }
}
