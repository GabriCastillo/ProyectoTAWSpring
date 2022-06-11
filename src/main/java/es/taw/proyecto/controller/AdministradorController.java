package es.taw.proyecto.controller;

import es.taw.proyecto.dto.CategoriaDTO;
import es.taw.proyecto.dto.ProductoDTO;
import es.taw.proyecto.dto.RolDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.Categoria;
import es.taw.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<UsuarioDTO> usuarios = this.usuarioService.filtrarNombreApellidoRol(filtroNombre, filtroApellido, filtroRol);
        usuarios = this.usuarioService.asignarRolEntity(usuarios);

        List<RolDTO> roles = this.rolservice.findAll();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("roles", roles);

        return "usuarios";
    }

    @GetMapping("/nuevoUsuario")
    public String doNewUsuario(Model model) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        List<RolDTO> roles = this.rolservice.findAll();
        model.addAttribute("usuario", usuarioDTO);
        model.addAttribute("roles", roles);

        return "usuario";
    }


    @GetMapping("/usuario/{id}")
    public String doUsuario(Model model, @PathVariable("id") String usuarioID) {
        UsuarioDTO usuario = this.usuarioService.findByID(Integer.parseInt(usuarioID));
        usuario = this.usuarioService.asignarRolEntity(usuario);

        List<RolDTO> roles = this.rolservice.findAll();
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roles);

        return "usuario";
    }

    @PostMapping("/usuario/save")
    public String doSaveUsuario(@ModelAttribute("producto") UsuarioDTO usuarioDTO) {
        this.usuarioService.save(usuarioDTO);

        return "redirect:/administrador/usuarios";

    }

    @GetMapping("/{id}/borrarUsuario")
    public String doDeleteUsuario(@PathVariable("id") String usuarioID) {
        this.usuarioService.borrar(Integer.parseInt(usuarioID));

        return "redirect:/administrador/usuarios";
    }


    @PostMapping("/cancelarUsuario")
    public String doCancelarUsuario() {
        return "redirect:/administrador/usuarios";
    }





    @GetMapping("/productos")
    public String doProductos(Model model, @RequestParam(value = "filtroTitulo", required = false) String filtroTitulo) {
        List<ProductoDTO> productos = this.productoService.FiltrarTitulo(filtroTitulo);
        productos = this.productoService.asignarCategoria(productos);

        List<CategoriaDTO> categorias = this.categoriaService.findAll();
        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);

        return "productos";
    }

    @GetMapping("/nuevoProducto")
    public String doNewProducto(Model model) {
        ProductoDTO productoDTO = new ProductoDTO();

        List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios("");
        List<CategoriaDTO> categorias = this.categoriaService.findAll();
        model.addAttribute("producto", productoDTO);
        model.addAttribute("categorias", categorias);
        model.addAttribute("usuarios", usuarios);

        return "producto";
    }

    @GetMapping("/producto/{id}")
    public String doProducto(Model model, @PathVariable("id") String productoID) {
        ProductoDTO productoDTO = this.productoService.findByID(Integer.parseInt(productoID));
        productoDTO = this.productoService.asignarRolEntity(productoDTO);
        List<UsuarioDTO> usuarios = this.usuarioService.listarUsuarios("");
        List<CategoriaDTO> categorias = this.categoriaService.findAll();
        model.addAttribute("producto", productoDTO);
        model.addAttribute("categorias", categorias);
        model.addAttribute("usuarios", usuarios);

        return "producto";
    }

    @PostMapping("/producto/save")
    public String doSaveProducto(@ModelAttribute("producto") ProductoDTO productoDTO) {
        this.productoService.save(productoDTO);

        return "redirect:/administrador/productos";

    }

    @GetMapping("/{id}/borrarProducto")
    public String doDeleteProducto(@PathVariable("id") String productoID) {
        this.productoService.borrar(Integer.parseInt(productoID));

        return "redirect:/administrador/productos";
    }

    @PostMapping("/cancelarProducto")
    public String doCancelarProducto() {
        return "redirect:/administrador/productos";
    }




    @GetMapping("/categorias")
    public String doCategorias(Model model, @RequestParam(value = "filtroTipo", required = false) String filtroTipo) {
        List<CategoriaDTO> categorias = this.categoriaService.listarCategorias(filtroTipo);
        model.addAttribute("categorias", categorias);

        return "categorias";
    }

    @GetMapping("/nuevaCategoria")
    public String doNewCategoria(Model model) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        model.addAttribute("categoria", categoriaDTO);

        return "categoria";
    }

    @GetMapping("/categoria/{id}")
    public String doCategoria(Model model, @PathVariable("id") String categoriaID) {
        CategoriaDTO categoriaDTO = this.categoriaService.findByID(Integer.parseInt(categoriaID));

        model.addAttribute("categoria", categoriaDTO);

        return "categoria";
    }

    @PostMapping("/categoria/save")
    public String doSaveCategoria(@ModelAttribute("categoria") CategoriaDTO categoriaDTO) {
        this.categoriaService.save(categoriaDTO);

        return "redirect:/administrador/categorias";

    }

    @GetMapping("/{id}/borrarCategoria")
    public String doDeleteCategoria(@PathVariable("id") String categoriaID) {
        this.categoriaService.borrar(Integer.parseInt(categoriaID));

        return "redirect:/administrador/categorias";
    }

    @PostMapping("/cancelarCategoria")
    public String doCancelarCategoria() {
        return "redirect:/administrador/categorias";
    }

}
