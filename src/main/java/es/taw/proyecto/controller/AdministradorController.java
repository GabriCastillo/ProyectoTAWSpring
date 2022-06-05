package es.taw.proyecto.controller;

import es.taw.proyecto.dto.RolDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("administrador")
public class AdministradorController {

    protected ListaService listaService;
    protected UsuarioService usuarioService;
    protected CategoriaService categoriaService;
    protected ProductoService productoService;
    protected Rolservice rolservice;

    public Rolservice getRolservice() {
        return rolservice;
    }

    @Autowired
    public void setRolservice(Rolservice rolservice) {
        this.rolservice = rolservice;
    }

    public ListaService getListaService() {
        return listaService;
    }

    @Autowired
    public void setListaService(ListaService listaService) {
        this.listaService = listaService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    @Autowired
    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public ProductoService getProductoService() {
        return productoService;
    }

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/usuarios")
    public String doUsuarios(Model model, @RequestParam(value = "filtroNombre", required = false) String filtroNombre, @RequestParam(value = "filtroApellido", required = false) String filtroApellido, @RequestParam(value = "filtroRol", required = false) String filtroRol) {
        List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios("");
        usuarios = this.usuarioService.asignarRolEntity(usuarios);

        List<RolDTO> roles = this.rolservice.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles",roles);

        return "usuarios";
    }

    @PostMapping("/usuarios/filtrarUsuarios")
    public String doFiltrar(Model model, @RequestParam(value = "filtroNombre", required = false) String filtroNombre, @RequestParam(value = "filtroApellido", required = false) String filtroApellido, @RequestParam(value = "filtroRol", required = false) String filtroRol) {
        List<UsuarioDTO> usuarios = this.usuarioService.filtrarNombreApellidoRol(filtroNombre, filtroApellido, filtroRol);
        usuarios = this.usuarioService.asignarRolEntity(usuarios);
        List<RolDTO> roles = this.rolservice.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles",roles);

        return "usuarios";
    }

    @GetMapping("/productos")
    public String doProductos(Model model, @RequestParam(value = "filtroTitulo", required = false) String filtroTitulo) {
        List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios("");
        usuarios = this.usuarioService.asignarRolEntity(usuarios);

        List<RolDTO> roles = this.rolservice.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles",roles);

        return "usuarios";
    }

    @GetMapping("/categorias")
    public String doCategorias(Model model, @RequestParam(value = "filtroNombre", required = false) String filtroNombre, @RequestParam(value = "filtroApellido", required = false) String filtroApellido, @RequestParam(value = "filtroRol", required = false) String filtroRol) {
        List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios("");
        usuarios = this.usuarioService.asignarRolEntity(usuarios);

        List<RolDTO> roles = this.rolservice.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles",roles);

        return "usuarios";
    }

}
