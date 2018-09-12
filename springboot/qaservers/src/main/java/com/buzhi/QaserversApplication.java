package com.buzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.buzhi.model")
public class QaserversApplication {

	public static void main(String[] args) {
		SpringApplication.run(QaserversApplication.class, args);
	}
}
