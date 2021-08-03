package com.movie.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableEurekaClient
@OpenAPIDefinition( info = @Info( title = "movie catalog service", version = "2.0.0", description = "movie catalog service description") )
public class MovieCatalogServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run( MovieCatalogServiceApplication.class, args );
    }
}
