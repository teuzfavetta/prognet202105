package br.com.albertoferes.springcontacts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatoController {

    @GetMapping("/contatos")
    public String getHomePage() {
        return "contatos";
    }
}
