package com.api.student.bootreststudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootRestStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestStudentApplication.class, args);
		System.out.println("Started");
	}

}