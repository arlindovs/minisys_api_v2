package com.learning.api.minisys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MinisysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinisysApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsLocalConfig() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
						.allowedHeaders("Origin","X-Requested-With", "Content-Type", "Accept", "Authorization")
						.allowedOrigins("http://localhost:4200");
			}
		};
	}

}
