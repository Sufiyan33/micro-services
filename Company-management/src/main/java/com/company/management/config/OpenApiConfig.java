package com.company.management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(
        contact = @Contact(name = "Sufiyan",
                email = "abc@gmail.com",
                url = "http://localhost:8081/cruds"),
        description = "OpenApi documentaion for spring boot crud apps",
        title = "OpenApi specification - Sufiyan",
        version = "1.0",
        license = @License(
                name = "Licence name",
                url = "http://localhost:808/"),
        termsOfService = "Terms of service declare here"),servers = {
        @Server(description = "Local env", url = "http://localhost:808/"),
        @Server(description = "Prod env", url = "http://localhost:808/") })
        public class OpenApiConfig {


//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("SpringShop API")
//                        .description("Spring shop sample application")
//                        .version("v0.0.1")
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .externalDocs(new ExternalDocumentation()
//                        .description("SpringShop Wiki Documentation")
//                        .url("https://springshop.wiki.github.org/docs"));
//    }

         }
