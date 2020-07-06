package com.mancio.edgeservice.swagger;

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
public class SpringFoxConfig {

    private static final String SECURITY_SCHEME_NAME = "spring_oauth";
    private static final String CLIENT_ID = "spring-security-oauth2-read-write-client";
    private static final String CLIENT_SECRET = "spring-security-oauth2-read-write-client-password1234";

    //@Value("${security.oauth2.client.user-authorization-uri}")
    //private String oauthtoken;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mancio.edgeservice"))
                .paths(PathSelectors.any())
                .build()
                // enable to authenticate manually on Swagger UI
                //.securitySchemes(Arrays.asList(securityScheme()))
                //.securityContexts(Arrays.asList(securityContext()))
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "301JavaMicro",
                "RESTFull API.",
                "1.0",
                "",
                new Contact("Andrea", " ", " "),
                " ", " ", Collections.emptyList());
    }


    /*@Bean
    public SecurityConfiguration securityInfo() {
        return SecurityConfigurationBuilder.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations")
        };

        return scopes;
    }

    private List<SecurityReference> securityReferences() {
        return Lists.newArrayList(new SecurityReference(SECURITY_SCHEME_NAME, scopes()));
    }

    @Bean
    public SecurityScheme securityScheme() {
        LoginEndpoint loginEndpoint = new LoginEndpoint(oauthtoken);
        GrantType grantType = new ImplicitGrant(loginEndpoint, OAuth2AccessToken.ACCESS_TOKEN);

        SecurityScheme oauth = new OAuthBuilder().name(SECURITY_SCHEME_NAME)
                .grantTypes(Lists.newArrayList(grantType))
                .scopes(Lists.newArrayList(scopes()))
                .build();

        return oauth;
    }

    @Bean
    public SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(securityReferences())
                .build();
    }*/


}
