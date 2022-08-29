package com.bjd.smartanalysis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private String basePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webfile/**").addResourceLocations("file:" + basePath);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").addResourceLocations("classpath:/resources/").addResourceLocations("classpath:/static/");
    }
}
