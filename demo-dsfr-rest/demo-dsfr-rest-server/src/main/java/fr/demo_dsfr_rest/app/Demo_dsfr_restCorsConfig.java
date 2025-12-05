package fr.demo_dsfr_rest.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Demo_dsfr_restCorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:5173", "http://localhost:8080").allowedMethods("*")
				.allowedHeaders("*").allowCredentials(true);
	}
}
