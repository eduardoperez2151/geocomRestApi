package com.geocom.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CORSConfig {

	@Value("${com.geocom.cors.allowedorigins}")
	private List<String> allowedOrigins;

	@Value("${com.geocom.cors.allowedmethods}")
	private List<String> allowedMethods;

	@Value("${com.geocom.cors.path}")
	private String path;


	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(allowedOrigins);
		configuration.setAllowedMethods(allowedMethods);
		final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration(path,new CorsConfiguration().applyPermitDefaultValues());
		return urlBasedCorsConfigurationSource;
	}

}
