/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.whatsup.bot.service;

import com.whatsup.bot.config.WhatsupSecurityConfig;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author Gonzalo_Avalos
 */
@Service
public class WhatsAppService {
   
    @Autowired
    WhatsupSecurityConfig config;
    
    private final WebClient webClient;

    @Autowired
    public WhatsAppService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void sendMessage(String recipientPhoneNumber, String messageText) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("messaging_product", "whatsapp");
        payload.put("to", recipientPhoneNumber);
        payload.put("type", "text");

        Map<String, String> text = new HashMap<>();
        text.put("body", messageText);
        payload.put("text", text);

        this.webClient.post()
                .body(Mono.just(payload), Map.class)
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> System.out.println("Response: " + response))
                .doOnError(error -> System.err.println("Error: " + error.getMessage()))
                .subscribe();
    }
    
    public String sendMenu()
    {
        return "";
    }
    
//    @PostMapping("/webhook")
        public ResponseEntity<Void> getResponse(@RequestBody String payload, 
                                          @RequestHeader("X-Hub-Signature") String signature)
    {
         try {
        String appSecret = "your_app_secret";
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(appSecret.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);
        //byte[] digest = mac.doFinal(payload.getBytes());

        String calculatedSignature = "sha256=" ; // + Hex.encodeHexString(digest);

        if (!calculatedSignature.equals(signature)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Procesa el payload aquí
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }

    /**
     * @return the webClient
     */

}
