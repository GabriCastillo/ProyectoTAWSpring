/*
Ruben 100%
 */
package es.taw.proyecto.controller;

import es.taw.proyecto.dto.*;
import es.taw.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("Misproductos")
public class MisProductosController {
    protected CategoriaService categoriaService;
    protected UsuarioService usuarioService;
    protected CompradorProductoService subastaservice;
    protected ProductoService productoService;

    @Autowired
    public void setProductoService(ProductoService productoService){this.productoService=productoService;}
    @Autowired
    public void setSubastaservice(CompradorProductoService subastaservice){this.subastaservice=subastaservice;}
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @Autowired
    public void setUsuarioService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping("/")
    public String doListar (Model model, HttpSession session) {


        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");
        model.addAttribute("usuario", user);

        List<CategoriaDTO> categorias = this.categoriaService.findall();
        model.addAttribute("categorias", categorias);

        List<CompradorProductoDTO> subastas = this.subastaservice.misproductos(user.getIdusuario());
        model.addAttribute("subastas", subastas);


        model.addAttribute("producto",null);

        return "MisProductos";
    }
    @PostMapping("/filtrar/")
    public String filtrar(Model model, HttpSession session, @RequestParam("filtroTitulo")String titulo, @RequestParam("categoria")String categoria){

        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");
        model.addAttribute("usuario", user);

        List<CategoriaDTO> categorias = this.categoriaService.findall();
        model.addAttribute("categorias", categorias);

        List<CompradorProductoDTO> subastas = this.subastaservice.misproductos(user.getIdusuario());
        List<CompradorProductoDTO> filtrado = this.subastaservice.misproductosfiltro(titulo,categoria,subastas);

        model.addAttribute("subastas", filtrado);


        model.addAttribute("producto",null);

        return "MisProductos";

    }
}
