package com.lds.student_currency_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentCurrencySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCurrencySystemApplication.class, args);
	}

}
