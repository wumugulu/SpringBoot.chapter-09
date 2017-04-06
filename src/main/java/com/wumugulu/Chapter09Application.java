package com.wumugulu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Chapter09Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter09Application.class, args);
	}
}
