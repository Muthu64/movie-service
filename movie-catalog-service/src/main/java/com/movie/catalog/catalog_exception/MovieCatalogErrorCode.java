package com.movie.catalog.catalog_exception;

import java.util.Arrays;
import java.util.List;

import com.movie.catalog.endpoint.MovieCatalogErrorPayload;
import com.movie.catalog.exception.ContextKey;
import com.movie.catalog.exception.ErrorCode;

public enum MovieCatalogErrorCode implements ErrorCode
{
    BAD_REQUEST( 400, "Bad request", MovieCatalogErrorPayload.class, CatalogContextKey.MOVIE_ID, CatalogContextKey.MOVIE_NAME ),
    INTERNAL_SERVER_ERROR( 500, "Internal Server request", null, CatalogContextKey.MOVIE_ID, CatalogContextKey.MOVIE_NAME );

    private int statusCode;
    private String internalMessage;
    private Class<?> payloadClass;
    private List<ContextKey> publicKeys;

    public enum CatalogContextKey implements ContextKey
    {
        MOVIE_ID,
        MOVIE_NAME,
        CLIENT_TYPE
    }

    MovieCatalogErrorCode( int statusCode, String internalMessage, Class<?> payloadClass, ContextKey... publicKeys )
    {
        this.statusCode = statusCode;
        this.internalMessage = internalMessage;
        this.payloadClass = payloadClass;
        this.publicKeys = Arrays.asList( publicKeys );
    }

    @Override
    public int getStatusCode()
    {
        return this.statusCode;
    }

    @Override
    public String getInternalErrorMessage()
    {
        return this.internalMessage;
    }

    @Override
    public List<ContextKey> publicKeys()
    {
        return this.publicKeys;
    }

    @Override
    public Class<?> payloadClass()
    {
        return this.payloadClass;
    }
}
