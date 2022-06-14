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
@RequestMapping("Iniciado")
public class IniciadoController {
    protected CategoriaService categoriaService;
    protected UsuarioService usuarioService;
    protected CompradorProductoService subastaservice;
    protected ProductoService productoService;
    protected FavoritoService favoritoService;
    @Autowired
    public void setFavoritoService(FavoritoService favoritoService){this.favoritoService=favoritoService;}
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
    public String doListar (Model model, HttpSession  session) {

        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");

        model.addAttribute("usuario", user);

        List<CategoriaDTO> categorias = this.categoriaService.findall();
        model.addAttribute("categorias", categorias);

        List<CompradorProductoDTO> subastas = this.subastaservice.findall();
        model.addAttribute("subastas", subastas);
        List<ProductoDTO> producto = this.productoService.findAll();
        model.addAttribute("productos", producto);
        List<FavoritoDTO> favoritos = this.favoritoService.misfavoritos(user.getIdusuario().toString());
        model.addAttribute("favoritos",favoritos);
        model.addAttribute("producto",null);

        return "iniciado";
    }

    @PostMapping("/pujar/")
    public String filtra(Model model, HttpSession  session,@RequestParam("slider")String precio,@RequestParam("id") String id){
        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");

        model.addAttribute("usuario", user);
        this.subastaservice.comprarSubasta(id,user.getIdusuario(),precio);
        return "redirect:/Iniciado/";
    }
    @PostMapping("/Favorito/{idsubasta}/")
    public String anadirfavorito(Model model,@PathVariable("idsubasta")String idsubasta, HttpSession  session){
        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");

        CompradorProductoDTO subasta = this.subastaservice.find(idsubasta);
        this.favoritoService.anadirfavorito(user.getIdusuario().toString(),subasta.getProductoIdproducto().toString());

        return "redirect:/Iniciado/";
    }
    @PostMapping("/QuitarFavorito/{idsubasta}/")
    public String quitarfavorito(Model model,@PathVariable("idsubasta")String idsubasta, HttpSession  session){
        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");
        CompradorProductoDTO subasta = this.subastaservice.find(idsubasta);
        this.favoritoService.quitarfavorito(user.getIdusuario().toString(),subasta.getProductoIdproducto().toString());

        return "redirect:/Iniciado/";
    }
    @PostMapping("/filtrar/")
    public String filtrar(Model model, HttpSession  session,@RequestParam("filtroTitulo")String titulo,@RequestParam("categoria")String categoria){

        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");
        model.addAttribute("usuario", user);
        List<CategoriaDTO> categorias = this.categoriaService.findall();
        model.addAttribute("categorias", categorias);

        List<CompradorProductoDTO> subastas = this.subastaservice.filtro(titulo,categoria);
        model.addAttribute("subastas", subastas);
        List<ProductoDTO> producto = this.productoService.filtro(titulo,categoria);
        model.addAttribute("productos", producto);
        List<FavoritoDTO> favoritos = this.favoritoService.findAll();
        model.addAttribute("favoritos",favoritos);
        model.addAttribute("producto",null);

        return "iniciado";

    }
}
