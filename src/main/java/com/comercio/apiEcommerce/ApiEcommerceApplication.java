package com.comercio.apiEcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication (scanBasePackages = {"com.comercio"})
@EntityScan(basePackages = "com.comercio")
@EnableJpaRepositories("com.comercio")
public class ApiEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEcommerceApplication.class, args);
	}

}
