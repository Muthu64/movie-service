package com.movie.catalog.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HystrixConfiguration
{
    @Bean
    public RatingHystrixFactory ratingHystrixFactory( @Value( "${coreSize: 10}" ) Integer coreSize,
                                                      @Value( "${maxQueueSize: 10}" ) Integer maxQueueSize,
                                                      @Value( "${queueSizeRejectionThreshold: 5}" ) Integer queueSizeRejectionThreshold,
                                                      @Value( "${executionTimeoutInMilliseconds: 15000}" ) Integer executionTimeoutInMilliseconds,
                                                      @Value( "${circuitBreakerRequestVolumeThreshold: 3}" ) Integer circuitBreakerRequestVolumeThreshold,
                                                      @Value( "${circuitBreakerSleepWindowInMilliseconds: 5000}" ) Integer circuitBreakerSleepWindowInMilliseconds,
                                                      @Value( "${circuitBreakerErrorThresholdPercentage: 10}" ) Integer circuitBreakerErrorThresholdPercentage,
                                                      @Value( "${metricsRollingStatsTimeInMilliseconds: 5000}" ) Integer metricsRollingStatsTimeInMilliseconds )
    {
        RatingHystrixFactory ratingHystrixFactory = new RatingHystrixFactory( RatingHystrixFactory.HYSTRIX_GROUP_KEY,
                                                                              RatingHystrixFactory.HYSTRIX_COMMAND_KEY,
                                                                              RatingHystrixFactory.HYSTRIX_THREAD_POOL_KEY,
                                                                              coreSize,
                                                                              maxQueueSize,
                                                                              queueSizeRejectionThreshold,
                                                                              executionTimeoutInMilliseconds,
                                                                              circuitBreakerRequestVolumeThreshold,
                                                                              circuitBreakerSleepWindowInMilliseconds,
                                                                              circuitBreakerErrorThresholdPercentage,
                                                                              metricsRollingStatsTimeInMilliseconds );

        return ratingHystrixFactory;
    }

}
