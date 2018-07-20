package com.rci.cat.service.test.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "demo.cosmos.core.Cat.service.*")
public class TestConfiguration {
    @Bean
    public ModelMapper modelMapper() {
	return new ModelMapper();
    }

}
