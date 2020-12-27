package com.movie.catalog.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import com.movie.catalog.endpoint.RatingHystrixCommand;
import com.movie.catalog.feign.clients.RatingFeignClient;
import com.netflix.hystrix.HystrixCommand;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RatingHystrixFactory
{
    protected static final String HYSTRIX_GROUP_KEY = RatingHystrixFactory.class.getName() + ".userRating";
    protected static final String HYSTRIX_COMMAND_KEY = RatingHystrixFactory.HYSTRIX_GROUP_KEY + ".userRating";
    protected static final String HYSTRIX_THREAD_POOL_KEY = RatingHystrixFactory.HYSTRIX_COMMAND_KEY + ".threadPool";

    @Autowired
    private RatingFeignClient ratingFeignClient;

    private HystrixCommand.Setter setter;

    public RatingHystrixFactory( String hystrixGGroupKey, String hystrixCommandKey, String hystrixThreadPoolKey, Integer coreSize, Integer maxQueueSize, Integer queueSizeRejectionThreshold, Integer executionTimeoutInMilliseconds, Integer circuitBreakerRequestVolumeThreshold, Integer circuitBreakerSleepWindowInMilliseconds, Integer circuitBreakerErrorThresholdPercentage, Integer metricsRollingStatsTimeInMillisecond )
    {
        this.setter = HystrixPropertiesSetter.INSTANCE.newSetter( hystrixGGroupKey, hystrixCommandKey, hystrixThreadPoolKey, coreSize, maxQueueSize, queueSizeRejectionThreshold, executionTimeoutInMilliseconds, circuitBreakerRequestVolumeThreshold, circuitBreakerSleepWindowInMilliseconds, circuitBreakerErrorThresholdPercentage, metricsRollingStatsTimeInMillisecond );
    }

    public RatingHystrixCommand userRatingHystrixCommand( String userId )
    {
        return new RatingHystrixCommand( getSetter(), this.ratingFeignClient, userId );
    }
}
