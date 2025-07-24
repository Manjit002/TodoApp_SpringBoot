package com.mjt.todoapplication.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    // Returns an instance of ModelMapper, which is used for object mapping
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
