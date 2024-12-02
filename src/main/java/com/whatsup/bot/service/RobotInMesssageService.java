/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.whatsup.bot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsup.bot.message.response.Root;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gonzalo_Avalos
 */
@Service
public class RobotInMesssageService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String eventoMessage = "c:\\dev\\GG\\Evento\\"; // Carpeta donde se guardan las reservas
    private final String outMessage = "c:\\dev\\GG\\Out\\"; // Carpeta donde se guardan las reservas

    public void SaveInconmeMessage(String incomingMessage) {
        if (incomingMessage.contains("Asesoramiento Virtual")) {
            Root message;
            try {
                message = objectMapper.readValue(incomingMessage, Root.class);
                String telefono = message.entry.get(0).changes.get(0).value.contacts.get(0).wa_id;
                File file = new File(eventoMessage + telefono + ".json");
                objectMapper.writeValue(file, "Llamar ahora.");

                File outfile = new File(outMessage + telefono + ".json");
                objectMapper.writeValue(outfile, "Muchas Gracias. Nos comunicaremos con usted a la brevedad.");

            } catch (JsonProcessingException ex) {
                Logger.getLogger(RobotInMesssageService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RobotInMesssageService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
