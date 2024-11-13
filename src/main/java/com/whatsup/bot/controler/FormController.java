/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.whatsup.bot.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.whatsup.bot.service.ContactService;

@Controller
public class FormController {
	
    @Autowired
	ContactService service;
	
    @PostMapping("/save")
    public String saveData(@RequestParam String nombre, 
                           @RequestParam String apellido, 
                           @RequestParam String telefono) {

        return service.save(nombre, apellido, telefono);
    }
}
