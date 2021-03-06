package com.brightaziz.app.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/users/**").allowedOrigins("http://localhost:3000").allowedMethods("GET","PUT","POST");
		registry.addMapping("/candidats/**").allowedOrigins("http://localhost:3000").allowedMethods("GET","PUT","POST");
	}
}
