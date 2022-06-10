package es.taw.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class inicioController {

    @GetMapping("/")
    public String doInit(){
        return "login";
    }
}
