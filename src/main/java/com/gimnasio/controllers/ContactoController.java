package com.gimnasio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviar(Model model) {
        model.addAttribute("mensaje", "Su mensaje fue enviado correctamente.");
        return "contacto";
    }
}
