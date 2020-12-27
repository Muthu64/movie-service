package com.movie.info.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieMessage
{
    CatalogItem catalogItem;

    @JsonCreator
    public MovieMessage( @JsonProperty("catalogItem") CatalogItem catalogItem )
    {
        this.catalogItem = catalogItem;
    }

    public CatalogItem getCatalogItem()
    {
        return catalogItem;
    }
}
