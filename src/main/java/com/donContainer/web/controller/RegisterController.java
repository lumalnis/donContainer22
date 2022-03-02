package com.donContainer.web.controller;

import com.donContainer.web.auth.service.UserDetailsServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserDetailsServiceCustom userService;


    @GetMapping("")
    public String registro() {
        return "registro";
    }

//        @PostMapping("")
//        public String registroSave(Model model,
//                                   @RequestBody User user) {
//            try {
//                userService.save(user);
//                return "redirect:/";
//            } catch (WebExceptionHandler ex) {
//                model.addAttribute("error", ex.getMessage());
//                model.addAttribute("username", username);
//            }
//            return "registro";
//        }
}
