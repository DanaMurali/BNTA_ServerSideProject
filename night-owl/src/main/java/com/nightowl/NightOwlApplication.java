package com.nightowl;

import com.nightowl.recipes.Recipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class NightOwlApplication {

	public static void main(String[] args) {

		SpringApplication.run(NightOwlApplication.class, args);
	}




}
