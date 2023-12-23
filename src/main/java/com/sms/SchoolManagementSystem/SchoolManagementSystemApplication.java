package com.sms.SchoolManagementSystem;

import com.sms.SchoolManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.Authentication;

@SpringBootApplication(exclude = {
		SecurityAutoConfiguration.class })
@EnableJpaRepositories("com.example.sms.repository")
@ComponentScan({
		"com.example.sms.repository",
		"com.example.sms.service",
		"com.example.sms.controller",
		"com.example.sms.domain",
})
public class SchoolManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	public static Authentication authenticatedUser;
	@Override
	public void run(String... args) throws Exception {

		
	}

}

