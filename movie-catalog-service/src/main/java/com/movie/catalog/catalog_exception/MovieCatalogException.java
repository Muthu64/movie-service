package com.movie.catalog.catalog_exception;

import java.util.Map;

import com.movie.catalog.exception.ContextKey;
import com.movie.catalog.exception.ErrorCode;
import com.movie.catalog.exception.MovieException;

public class MovieCatalogException extends MovieException
{
    private MovieCatalogErrorCode movieCatalogErrorCode;
    private String errorMessage;
    private Map<? extends ContextKey, String> contextKeys;
    private Object payload;
    private Throwable cause;

    public MovieCatalogException( String message, Throwable cause, ErrorCode errorCode, Map<? extends ContextKey, String> contextKeys, Object payload )
    {
        super( message, cause, errorCode, contextKeys, payload );

        this.movieCatalogErrorCode = movieCatalogErrorCode;
        this.errorMessage = errorMessage;
        this.contextKeys = contextKeys;
        this.payload = payload;
        this.cause = cause;
    }

    public MovieCatalogErrorCode getMovieCatalogErrorCode()
    {
        return movieCatalogErrorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    @Override
    public Map<? extends ContextKey, String> getContextKeys()
    {
        return contextKeys;
    }

    @Override
    public Object getPayload()
    {
        return payload;
    }

    @Override
    public Throwable getCause()
    {
        return cause;
    }
}
