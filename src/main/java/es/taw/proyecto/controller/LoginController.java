package es.taw.proyecto.controller;

import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.Usuario;
import es.taw.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    protected UsuarioService usuarioService;

    public UsuarioService getUsuarioService() {
        return this.usuarioService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String doInit () {
        return "login";
    }

    @PostMapping("/autentica")
    public String doAutentica (Model model, HttpSession session, @RequestParam("usuario") String user, @RequestParam("clave") String password) {
        String goTo = "login";

        UsuarioDTO usuario = this.usuarioService.comprobarCredenciales(user, password);
        session.setAttribute("usuario", usuario);

        if (usuario == null) {
            model.addAttribute("error", "usuario o contraseña incorrectos");
        } else {
            switch (usuario.getRolIdrol()) {
                case 1:
                    return null;
                case 2:
                    return null;
                case 3:
                    return null;
                case 4:
                    goTo = "redirect:/marketing/";
            }
        }

        return goTo;
    }

    @GetMapping("/salir")
    public String doExit (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
