package com.whatsup.bot.controler;

import com.whatsup.bot.service.WhatsAppService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class botControler {
@Autowired  
    WhatsAppService whatsAppService;
	private Logger log = LoggerFactory.getLogger(botControler.class);
	   
	   @GetMapping("/hello")
	    public ResponseEntity<String> exportOpportunity()  {
	    	
	        return new ResponseEntity<>("Hello", HttpStatus.OK );
	    }
            
    @GetMapping("/sendMessage")
    public String sendMessage() {
        whatsAppService.sendMessage("541145587174", "Hello from Spring!");
        return "Message sent!";
    }
}

