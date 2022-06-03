package es.taw.proyecto.controller;

import es.taw.proyecto.dto.*;
import es.taw.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("correo")
public class CorreoController {
    protected ListaService listaService;
    protected UsuarioService usuarioService;
    protected CategoriaService categoriaService;
    protected ProductoService productoService;
    protected CorreoService correoService;

    public UsuarioService getUsuarioService() {
        return this.usuarioService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public CategoriaService getCategoriaService() {
        return this.categoriaService;
    }

    @Autowired
    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    public ListaService getListaService() {
        return this.listaService;
    }

    @Autowired
    public void setListaService(ListaService listaService) {
        this.listaService = listaService;
    }

    public ProductoService getProductoService() {
        return this.productoService;
    }

    @Autowired
    public void setProductoService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public CorreoService getCorreoService() {
        return this.correoService;
    }

    @Autowired
    public void setCorreoService(CorreoService correoService) {
        this.correoService = correoService;
    }

    @GetMapping("/{usuarioID}/")
    public String doListar (Model model, @PathVariable("usuarioID") Integer usuarioID) {
        List<CorreoDTO> correos = this.correoService.listarCorreos(usuarioID);
        model.addAttribute("correosUsuario", correos);

        List<ProductoDTO> productos = this.productoService.listarProductosDisponibles();
        model.addAttribute("productosLista", productos);

        String nombreCompleto = this.usuarioService.obtenerNombreCompleto(usuarioID);
        model.addAttribute("nombreUsuario", nombreCompleto);

        return "correo";
    }
}
