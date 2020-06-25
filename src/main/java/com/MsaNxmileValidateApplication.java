package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MsaNxmileValidateApplication {
	private static final String PROPERTIES =
			"spring.config.location="
					+ "classpath:/config/application/";
	public static void main(String[] args) {
		new SpringApplicationBuilder(MsaNxmileValidateApplication.class)
				.properties(PROPERTIES)
				.run(args);
	}

}
