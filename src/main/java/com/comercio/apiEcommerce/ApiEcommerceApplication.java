package com.comercio.apiEcommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication (scanBasePackages = {"com.comercio"})
@EntityScan(basePackages = "com.comercio")
//@EnableJpaRepositories(basePackages = "com.cibertec")
public class ApiEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEcommerceApplication.class, args);
	}

}
