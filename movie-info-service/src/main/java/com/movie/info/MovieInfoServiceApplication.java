package com.movie.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@OpenAPIDefinition( info = @Info( title = "movie info service", version = "2.0.0", description = "movie info service description") )
public class MovieInfoServiceApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run( MovieInfoServiceApplication.class, args );
    }
}
