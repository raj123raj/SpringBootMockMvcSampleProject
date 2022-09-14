package com.gfg.gfgsample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gfg.gfgsample.domain.GeekEmployee;
import com.gfg.gfgsample.service.GeekEmployeeService;

@SpringBootApplication
public class TestSpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringmvcApplication.class, args);
	}

	@Bean
	CommandLineRunner init(GeekEmployeeService geekEmployeeService) {
	    return args -> {
	        geekEmployeeService.save(new GeekEmployee("Rachel", "Green", 100000));
	        geekEmployeeService.save(new GeekEmployee("Monica", "Geller", 40000));
	        geekEmployeeService.save(new GeekEmployee("Phoebe", "", 45000));
	    };
	}
}
