package es.taw.proyecto.controller;

import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.Usuario;
import es.taw.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String doInit() {
        return "login";
    }

    @PostMapping("/autentica")
    public String doAutentica(Model model, HttpSession session, @RequestParam("usuario") String user, @RequestParam("clave") String password) {
        UsuarioDTO usuario = this.usuarioService.comprobarCredenciales(user, password);
        session.setAttribute("usuario", usuario);

        if (usuario == null) {
            model.addAttribute("error", "usuario o contraseña incorrectos");
        } else {
            switch (usuario.getRolIdrol()) {
                case 1:
                    return "redirect:/administrador/usuarios";
                case 2:
                    return null;
                case 3:
                    return null;
                case 4:
                    return "redirect:/marketing/";
            }
        }

        return "login";
    }

    @GetMapping("/salir")
    public String doExit(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/registro")
    public String doRegistro(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("usuario", usuarioDTO);
        return "registro";
    }

    @PostMapping("/save")
    public String doSaveUsuario(@ModelAttribute("usuario") UsuarioDTO usuarioDTO, Model model) {
        if(usuarioDTO.getPassword2().equals(usuarioDTO.getPassword())){
            this.usuarioService.save(usuarioDTO);
        }else{
            String error="Las contraseñas no coinciden";
            model.addAttribute("error",error);
            model.addAttribute("usuario",usuarioDTO);
            return "registro";
        }

        return "redirect:/";

    }

    @PostMapping("/")
    public String doCancelar() {
        return "redirect:/";
    }


}
