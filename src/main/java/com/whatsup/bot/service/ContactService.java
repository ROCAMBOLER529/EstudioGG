package com.whatsup.bot.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.whatsup.bot.config.ContactConfig;


@Service
public class ContactService {
	
	@Autowired
	ContactConfig config;
	
	public String save(String nombre, String apellido, String telefono)
	{
	      String fileName = telefono + ".json";
	        File file = Paths.get(config.path, fileName).toFile();

	        if (file.exists()) {
	            return "redirect:/error?message=El archivo ya existe";
	        }

	        Map<String, String> data = new HashMap<>();
	        data.put("nombre", nombre);
	        data.put("apellido", apellido);
	        data.put("telefono", telefono);

	        ObjectMapper mapper = new ObjectMapper();
	        try (FileWriter writer = new FileWriter(file)) {
	            mapper.writerWithDefaultPrettyPrinter().writeValue(writer, data);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "redirect:/error?message=Error al guardar el archivo";
	        }
		return "redirect:/contactos";
		
	}
}
