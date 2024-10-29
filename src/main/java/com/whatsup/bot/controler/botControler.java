package com.whatsup.bot.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.whatsup.bot.BotApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class botControler {
  
	private Logger log = LoggerFactory.getLogger(botControler.class);
	   
	   @GetMapping("/hello")
	    public ResponseEntity<String> exportOpportunity()  {
	    	
	        return new ResponseEntity<>("Hello", HttpStatus.OK );
	    }
}

