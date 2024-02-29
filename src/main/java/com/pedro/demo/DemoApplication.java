package com.pedro.demo;

import com.pedro.demo.conf.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication   {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
