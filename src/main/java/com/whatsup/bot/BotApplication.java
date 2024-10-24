package com.whatsup.bot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BotApplication implements CommandLineRunner { 

	
	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);
		
	}
	
	@Override
    public void run(String... args) {
		 log.info("Hello World from Application Runner");
		 System.exit(0);
    }
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
