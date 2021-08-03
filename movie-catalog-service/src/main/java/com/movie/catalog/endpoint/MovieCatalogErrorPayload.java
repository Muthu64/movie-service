package com.movie.catalog.endpoint;

public class MovieCatalogErrorPayload
{
    private String errorMessage;

    public MovieCatalogErrorPayload( String errorMessage )
    {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }
}
