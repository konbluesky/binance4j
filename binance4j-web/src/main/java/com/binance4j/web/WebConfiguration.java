package com.binance4j.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.binance4j.connectors.Connectors;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebSecurity
@Configuration
public class WebConfiguration {

	@Bean
	public Connectors getConnectors() {
		return new Connectors(System.getenv("BINANCE_API_KEY"), System.getenv("BINANCE_API_SECRET"));
	}

	// Config

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		security.httpBasic().disable();
		return security.build();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

}