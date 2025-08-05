package com.web.expensetracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
		System.out.println("Expense Tracker Application is running!");
	}

	@Bean
	public CommandLineRunner printEndpoints(ApplicationContext ctx) {
		return args -> {
			RequestMappingHandlerMapping mapping = ctx.getBean(RequestMappingHandlerMapping.class);
			mapping.getHandlerMethods().forEach((k, v) -> System.out.println("✅ Mapped: " + k));
		};
	}

}
