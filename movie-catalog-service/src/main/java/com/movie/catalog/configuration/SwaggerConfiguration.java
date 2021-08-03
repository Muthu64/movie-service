/*
package com.movie.catalog.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration
{
    @Bean
    public Docket postsApi() {
        return new Docket( DocumentationType.SWAGGER_2).groupName("Movie catalog service").apiInfo(apiInfo()).select()
                .paths(regex("/catalog.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Movie catalog service")
                .description("Sample Documentation Generateed Using SWAGGER2 for movie catalog service")
                //.termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
                //.license("Java_Gyan_Mantra License")
                //.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0")
                .build();
    }
}
*/
