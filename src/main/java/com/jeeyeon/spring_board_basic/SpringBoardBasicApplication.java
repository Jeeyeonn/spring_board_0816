package com.jeeyeon.spring_board_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBoardBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoardBasicApplication.class, args);
	}

}
