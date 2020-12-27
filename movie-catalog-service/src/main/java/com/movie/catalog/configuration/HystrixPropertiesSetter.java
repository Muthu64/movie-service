package com.movie.catalog.configuration;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public enum HystrixPropertiesSetter
{
    INSTANCE;

    public HystrixCommand.Setter newSetter( String hystrixGGroupKey, String hystrixCommandKey, String hystrixThreadPoolKey, Integer coreSize, Integer maxQueueSize, Integer queueSizeRejectionThreshold, Integer executionTimeoutInMilliseconds, Integer circuitBreakerRequestVolumeThreshold, Integer circuitBreakerSleepWindowInMilliseconds, Integer circuitBreakerErrorThresholdPercentage, Integer metricsRollingStatsTimeInMillisecond )
    {
        return HystrixCommand.Setter.withGroupKey( HystrixCommandGroupKey.Factory.asKey( hystrixGGroupKey ) ).andCommandKey( HystrixCommandKey.Factory.asKey( hystrixCommandKey ) ).andThreadPoolKey( HystrixThreadPoolKey.Factory.asKey( hystrixThreadPoolKey ) ).andThreadPoolPropertiesDefaults( HystrixThreadPoolProperties.Setter().withCoreSize( coreSize ).withMaxQueueSize( maxQueueSize ).withQueueSizeRejectionThreshold( queueSizeRejectionThreshold ) ).andCommandPropertiesDefaults( HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds( executionTimeoutInMilliseconds ).withCircuitBreakerRequestVolumeThreshold( circuitBreakerRequestVolumeThreshold ).withCircuitBreakerSleepWindowInMilliseconds( circuitBreakerSleepWindowInMilliseconds ).withCircuitBreakerErrorThresholdPercentage( circuitBreakerErrorThresholdPercentage ).withMetricsRollingStatisticalWindowInMilliseconds( metricsRollingStatsTimeInMillisecond ) );
    }
}
