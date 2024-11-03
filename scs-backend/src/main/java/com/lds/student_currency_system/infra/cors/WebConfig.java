package com.lds.student_currency_system.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // registry.addMapping("/**")
        //         .allowedOrigins("http://localhost:5173")
        //         .allowedMethods("GET", "POST", "DELETE", "PUT");

        registry.addMapping("/**")
            .allowedOrigins("*") 
            .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS");
    }
}
