package com.brightaziz.app.ws;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/users").allowedMethods("GET","PUT","POST").allowedOrigins("http://localhost:3000");
	}
}
