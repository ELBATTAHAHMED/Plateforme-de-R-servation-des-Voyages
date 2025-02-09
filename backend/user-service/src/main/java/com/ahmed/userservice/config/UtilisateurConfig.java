//
//package com.ahmed.userservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.modelmapper.ModelMapper;
//
//@Configuration
//public class UtilisateurConfig {
//
//	 @Bean
//	    public ModelMapper modelMapperBean() {
//	        return new ModelMapper();
//	 }
//
//
//
//	  public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**") // Toutes les routes
//	                .allowedOrigins("http://localhost:5500")
//	                .allowedMethods("GET", "POST", "PUT", "DELETE")
//	                .allowedHeaders("*")
//	                .allowCredentials(true);
//	    }
//}
//
//
//
