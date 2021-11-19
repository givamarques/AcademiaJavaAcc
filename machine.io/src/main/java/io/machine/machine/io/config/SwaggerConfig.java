package io.machine.machine.io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("io.machine.machine.io"))
//                .paths("/api.*")
//                .build()
//                .apiInfo(metaInfo());
//    }

//    private ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "Produtos API REST",
//                "API REST de cadastro de produtos.",
//                "1.0",
//                "Terms of Service",
//                new Contact("Michelli Brito", "https://www.youtube.com/michellibrito",
//                        "michellidibrito@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
//        );
//
//        return apiInfo;
}
