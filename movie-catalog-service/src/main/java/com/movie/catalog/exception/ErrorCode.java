package com.movie.catalog.exception;

import java.util.List;
import java.util.Map;

public interface ErrorCode
{
    int getStatusCode();

    String getInternalErrorMessage();

    List<ContextKey> publicKeys();

    Class<?> payloadClass();
}
