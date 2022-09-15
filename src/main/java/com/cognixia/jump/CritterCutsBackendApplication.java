package com.cognixia.jump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(title="Critter Cuts API Application Backend", version="0.1", description = "API that allows employees of Critter Cuts to schedule grooming sessions for customer's pets"), externalDocs = @ExternalDocumentation(description = "Github for backend development", url = "https://github.com/nwburn3981/CritterCutsBackend")
)
public class CritterCutsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CritterCutsBackendApplication.class, args);
	}

}
