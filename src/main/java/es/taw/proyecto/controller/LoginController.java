package es.taw.proyecto.controller;

import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    protected UsuarioRepository usuarioRepository;

    public UsuarioRepository getUsuarioRepository() {
        return this.usuarioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public String doInit () {
        return "login";
    }

    @PostMapping("/autentica")
    public String doAutentica (Model model, HttpSession session, @RequestParam("usuario") String user, @RequestParam("clave") String password) {
        String goTo = "redirect:/usuario/";

        Usuario usuario = this.usuarioRepository.findUsuarioByNombreAndPassword(user, password);
        session.setAttribute("usuario", usuario);

        if (usuario == null) {
            model.addAttribute("error", "usuario o contraseña incorrectos");
            goTo = "login";
        }

        return goTo;
    }

    @GetMapping("/salir")
    public String doExit (HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
