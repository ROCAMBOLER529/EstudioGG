package com.whatsup.bot.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class botControler {
  
	   
	   @GetMapping("/hello")
	    public ResponseEntity<String> exportOpportunity()  {
	    	
	
	    	
	        return new ResponseEntity<>("Hello", HttpStatus.OK );
	    }
}

