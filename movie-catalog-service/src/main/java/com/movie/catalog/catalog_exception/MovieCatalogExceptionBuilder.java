package com.movie.catalog.catalog_exception;

import java.util.HashMap;
import java.util.Map;

import com.movie.catalog.exception.ContextKey;

public class MovieCatalogExceptionBuilder
{
    private MovieCatalogErrorCode movieCatalogErrorCode;
    private String errorMessage;
    private Map<? extends ContextKey, String> contextKeys;
    private Object payload;
    private Throwable cause;

    public MovieCatalogExceptionBuilder()
    {
        contextKeys = new HashMap<>();
    }

    public MovieCatalogErrorCode getMovieCatalogErrorCode()
    {
        return movieCatalogErrorCode;
    }

    public MovieCatalogExceptionBuilder setMovieCatalogErrorCode( MovieCatalogErrorCode movieCatalogErrorCode )
    {
        this.movieCatalogErrorCode = movieCatalogErrorCode;
        return this;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public MovieCatalogExceptionBuilder setErrorMessage( String errorMessage )
    {
        this.errorMessage = errorMessage;
        return this;
    }

    public Map<? extends ContextKey, String> getContextKeys()
    {
        return contextKeys;
    }

    public MovieCatalogExceptionBuilder setContextKeys( Map<? extends ContextKey, String> contextKeys )
    {
        this.contextKeys = contextKeys;
        return this;
    }

    public Object getPayload()
    {
        return payload;
    }

    public MovieCatalogExceptionBuilder setPayload( Object payload )
    {
        this.payload = payload;
        return this;
    }

    public Throwable getCause()
    {
        return cause;
    }

    public MovieCatalogExceptionBuilder setCause( Throwable cause )
    {
        this.cause = cause;
        return this;
    }

    public MovieCatalogExceptionBuilder addContextKey( MovieCatalogErrorCode.CatalogContextKey catalogContextKey, String errorMessage )
    {
        //this.contextKeys.put( catalogContextKey, errorMessage );
        return this;
    }

    public MovieCatalogException build()
    {
        return new MovieCatalogException( this.errorMessage, this.cause, this.movieCatalogErrorCode, this.contextKeys, this.payload );
    }

    public void buildAndThrow()
    {
        MovieCatalogException movieCatalogException = this.build();
        throw movieCatalogException;
    }
}
