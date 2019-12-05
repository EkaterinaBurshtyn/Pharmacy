package org.burshtyn.pharmacy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${app.swagger.base-path}")
    private String basePath;

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Coursework of Burshtyn Ekaterina Gennadevna",
                null,
                null,
                null,
                new Contact("Burshtyn Ekaterina Gennadevna", null, "ktbrstn@gmail.com"),
                "free", null, Collections.emptyList());
    }

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
            Collections.singletonList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathProvider(getPathProvider())
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.burshtyn.pharmacy"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private AbstractPathProvider getPathProvider() {
        return new AbstractPathProvider() {
            @Override
            protected String applicationPath() {
                return basePath;
            }

            @Override
            protected String getDocumentationPath() {
                return basePath;
            }
        };
    }

}