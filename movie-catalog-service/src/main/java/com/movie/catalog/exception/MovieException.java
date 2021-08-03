package com.movie.catalog.exception;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MovieException extends RuntimeException
{
    private ErrorCode errorCode;
    private Map< ? extends ContextKey, String> contextKeys;
    private Object payload;

    public MovieException( String message, Throwable cause, ErrorCode errorCode, Map<? extends ContextKey, String> contextKeys, Object payload )
    {
        super( message, cause );

        this.errorCode = errorCode;
        this.contextKeys = contextKeys;
        this.payload = this.processPayload( payload );
    }

    private Object processPayload( Object payload )
    {
        Object payloadResult = null;

        Class<?> payloadClass = errorCode.payloadClass();

        if( payloadClass.isInstance( payload ) )
        {
            payloadResult = payload;
        }

        return payloadResult;
    }

    public ErrorCode getErrorCode()
    {
        return errorCode;
    }

    public Map<? extends ContextKey, String> getContextKeys()
    {
        return contextKeys;
    }

    public Object getPayload()
    {
        return payload;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder( this )
                .append( "errorCode", errorCode )
                .append( "contextKeys", contextKeys )
                .append( "payload", payload )
                .toString();
    }
}
