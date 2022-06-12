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

    @GetMapping("/{user}")
    public String doListar (Model model, @PathVariable String user) {


        UsuarioDTO compradores = this.usuarioService.idusuario(user).toDTO();
        model.addAttribute("usuario", compradores);

        List<CategoriaDTO> categorias = this.categoriaService.findall();
        model.addAttribute("categorias", categorias);

        List<CompradorProductoDTO> subastas = this.subastaservice.findall();
        model.addAttribute("subastas", subastas);
        List<ProductoDTO> producto = this.productoService.findAll();
        model.addAttribute("productos", producto);
        List<FavoritoDTO> favoritos = this.favoritoService.misfavoritos(user);
        model.addAttribute("favoritos",favoritos);
        model.addAttribute("producto",null);

        return "iniciado";
    }

    @PostMapping("/pujar/{user}")
    public String filtra(Model model, @PathVariable String user,@RequestParam("slider")String precio,@RequestParam("id") String id){
        UsuarioDTO compradores = this.usuarioService.idusuario(user).toDTO();
        model.addAttribute("usuario", compradores);
        this.subastaservice.comprarSubasta(id,Integer.parseInt(user),precio);
        return "redirect:/Iniciado/"+compradores.getIdusuario();
    }
    @PostMapping("/Favorito/{idsubasta}/{iduser}")
    public String anadirfavorito(Model model,@PathVariable("idsubasta")String idsubasta,@PathVariable("iduser")String user){
        UsuarioDTO compradores = this.usuarioService.idusuario(user).toDTO();
        CompradorProductoDTO subasta = this.subastaservice.find(idsubasta);
        this.favoritoService.anadirfavorito(user,subasta.getProductoIdproducto().toString());

        return "redirect:/Iniciado/"+compradores.getIdusuario();
    }
    @PostMapping("/QuitarFavorito/{idsubasta}/{iduser}")
    public String quitarfavorito(Model model,@PathVariable("idsubasta")String idsubasta,@PathVariable("iduser")String user){
        UsuarioDTO compradores = this.usuarioService.idusuario(user).toDTO();
        CompradorProductoDTO subasta = this.subastaservice.find(idsubasta);
        this.favoritoService.quitarfavorito(user,subasta.getProductoIdproducto().toString());

        return "redirect:/Iniciado/"+compradores.getIdusuario();
    }
    @PostMapping("/filtrar/{id}")
    public String filtrar(Model model,@PathVariable String id,@RequestParam("filtroTitulo")String titulo,@RequestParam("categoria")String categoria){

        UsuarioDTO compradores = this.usuarioService.idusuario(id).toDTO();
        model.addAttribute("usuario", compradores);
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
