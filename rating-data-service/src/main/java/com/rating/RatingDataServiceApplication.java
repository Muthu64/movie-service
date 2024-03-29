package com.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition( info = @Info( title = "movie rating service", version = "2.0.0", description = "movie rating service description") )
public class RatingDataServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run( RatingDataServiceApplication.class, args );
    }
}
