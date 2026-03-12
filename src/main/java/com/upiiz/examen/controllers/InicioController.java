package com.upiiz.examen.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class InicioController {

    @GetMapping("/")
    public String inicio(){
        return "redirect:/examen";
    }
}
