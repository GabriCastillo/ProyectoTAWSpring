package es.taw.proyecto.controller;

import es.taw.proyecto.dao.RolRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.RolEntity;
import es.taw.proyecto.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("user")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    public RolRepository getRolRepository() {
        return rolRepository;
    }

    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public String doListar (Model model) {

        List<UsuarioEntity> lista = this.usuarioRepository.findAll();
        model.addAttribute("usuarios", lista);


        return "usuarios";
    }

    @GetMapping("/{id}/edit")
    public String doEditar (@PathVariable("id") Integer customerID,
                            Model model) {
        UsuarioEntity usuario = this.usuarioRepository.findById(customerID).orElse(null);
        List<RolEntity> listaRoles = this.rolRepository.findAll();
        model.addAttribute("cliente", usuario.toDTO());
        model.addAttribute("roles", listaRoles);

        return "cliente";
    }

    @GetMapping("/{id}/delete")
    public String doBorrar (@PathVariable("id") Integer usuarioID) {
        this.usuarioRepository.deleteById(usuarioID);
        return "redirect:/usuario/";
    }

    @PostMapping("/save")
    public String doGuardar (@ModelAttribute("usuario") UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setMicroMarketByZip(mm);
        //this.customerRepository.save(clienteEntidad); !! No funciona porque hay que añadir el código de descuento
        return "redirect:/usuario/";
    }


}
