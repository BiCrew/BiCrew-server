package com.bicrew.bicrew.api.config;

import com.bicrew.bicrew.support.AuthenticationPrincipalArgumentResolver;
import com.bicrew.bicrew.support.JwtProvider;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final String ALLOWED_METHOD_NAMES = "GET,HEAD,POST,DELETE,TRACE,OPTIONS,PATCH,PUT";

    private final JwtProvider jwtProvider;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods(ALLOWED_METHOD_NAMES.split(","))
                .allowedHeaders("*")
                .exposedHeaders(HttpHeaders.LOCATION, HttpHeaders.AUTHORIZATION);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authenticationPrincipalArgumentResolver());
    }

    @Bean
    public AuthenticationPrincipalArgumentResolver authenticationPrincipalArgumentResolver() {
        return new AuthenticationPrincipalArgumentResolver(jwtProvider);
    }
}
