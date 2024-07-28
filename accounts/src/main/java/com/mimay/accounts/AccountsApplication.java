package com.mimay.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "first microservices journey",
				description = "Accounts microservice REST API Documentation",
				version = "1.0",
				contact = @Contact(
						name = "mimay",
						email = "fachritaufann@gmail.com",
						url = "https://github.com/mrpalamedes"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://github.com/mrpalamedes"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "extends springboot knowledge with udemy",
				url = "https://www.udemy.com/"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
