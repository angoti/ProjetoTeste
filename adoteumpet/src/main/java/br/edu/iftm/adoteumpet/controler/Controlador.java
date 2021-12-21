package br.edu.iftm.adoteumpet.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @GetMapping(value = { "/", "/home" })
    public String home() {
        return "home";
    }

    @GetMapping(value = "/perfil")
    public String perfil() {
        return "perfil";
    }

    @GetMapping(value = "/contato")
    public String contato() {
        return "contato";
    }

    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    @GetMapping("/apoio")
    public String apoio() {
        return "apoio";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
