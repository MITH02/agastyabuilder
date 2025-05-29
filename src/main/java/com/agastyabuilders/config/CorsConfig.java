package com.agastyabuilders.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowedOrigins(Arrays.asList(
				"http://localhost:3000",
				"https://agastyabuildersanddevelopers.onrender.com",
				"https://agastyabuildersanddevelopers.com",
				"https://www.agastyabuildersanddevelopers.com"
		));

		config.setAllowCredentials(true);
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
}
