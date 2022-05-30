package es.taw.proyecto.controller;

import es.taw.proyecto.dao.ListaRepository;
import es.taw.proyecto.entity.Lista;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    @GetMapping("/")
    public String identificarRol (HttpSession session) {
        Usuario user = (Usuario)session.getAttribute("usuario");
        switch (user.getRolIdrol()) {
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return "redirect:/marketing/";
            default:
                return null;
        }
    }
}
