package com.donContainer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/administrar")
    public String administrar() {
        return "administracion.html";
    }

    @GetMapping("/productos")
    public String productos() {
        return "productos.html";
    }

    @GetMapping("/contactus")
    public String contacto() {
        return "contactus.html";
    }

    @GetMapping("/alquiler")
    public String alquiler() {
        return "alquiler.html";
    }

    @GetMapping("/inspirate")
    public String inspirate(){ return "inspirate.html";}
}
