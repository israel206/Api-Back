package com.api.apiback.config;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	
	@Bean
    public Docket recliclagemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.api.apiback"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
    	
        ApiInfo apiInfo = new ApiInfo(
                "Reciclagem API REST",
                "API REST Vendas de Reciclagem.",
                "1.0",
                "Terms of Service",
                new Contact("Isreal, Alan, Gabriel e Carlos","Trabalhando duro",
                        "israel.pereira@dcx.ufpb.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
      
    }

}


