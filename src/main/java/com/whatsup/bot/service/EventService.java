/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.whatsup.bot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsup.bot.config.ContactConfig;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gonzalo_Avalos
 */
@Service
public class EventService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    ContactConfig config;

    public void saveEvent(String id, String evento) {
        File file = new File(config.path + "/evento/" + id + ".json");
        try {
            objectMapper.writeValue(file, evento);
        } catch (IOException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
