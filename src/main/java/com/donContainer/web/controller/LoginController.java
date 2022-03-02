package com.donContainer.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String login(Model model,
                        @RequestParam(required = false) String error,
                        @RequestParam(required = false) String mail,
                        @RequestParam(required = false) String logout) {

        if (error != null) {
            model.addAttribute("error", "El mail o contraseña es inválido.");
        }
        if (error != null) {
            model.addAttribute("username", mail);
        }

        return "listar";
    }
}
