package com.umanizales.apipaseobarcos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apiPaseoPerrosDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("PaseoPerros")
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "com.umanizales.apipaseobarcos.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(getApiInfo());
    }
    //Agregar método información o documentación de mi api
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "API Paseo Barcos Lista SE ",
                "Api que permite gestionar todo el backend de listas SE y DE",
                "1.0",
                "http://www.umanizales.com/",
                new Contact("Andres Romero", "http://www.umanizales.edu.co/",
                        "afromero69882@umanizales.edu.co"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
