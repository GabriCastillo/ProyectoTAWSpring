package es.taw.proyecto.controller;

import es.taw.proyecto.dto.*;
import es.taw.proyecto.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("lista")
public class ListaController {
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

    @GetMapping("/{listaNombre}/")
    public String doListar (Model model, @PathVariable("listaNombre") String listaNombre, @RequestParam(value = "filtroCompradorAll", required = false) String filtroCompradorAll) {
        List<ListaDTO> listaClientes = this.listaService.listarListas(listaNombre);
        model.addAttribute("compradoresLista", listaClientes);

        List<CategoriaDTO> categoriasUltimasLista = this.categoriaService.listarCategoriasUltimasLista(listaClientes);
        model.addAttribute("ultimasCategoriasLista", categoriasUltimasLista);

        List<ProductoDTO> productos = this.productoService.listarProductosDisponibles();
        model.addAttribute("productosLista", productos);

        List<UsuarioDTO> compradores = this.usuarioService.listarUsuariosCompradores(this.usuarioService.listarUsuarios(filtroCompradorAll));
        model.addAttribute("compradores", compradores);

        List<CategoriaDTO> categoriasUltimas = this.categoriaService.listarCategoriasUltimas(compradores);
        model.addAttribute("ultimasCategorias", categoriasUltimas);

        return "lista";
    }

    @GetMapping("/{listaID}/{usuarioID}/crearListaUsuario")
    public String doCrearListaUsuario (@PathVariable("listaID") Integer listaID, @PathVariable("usuarioID") Integer usuarioID) {
        this.listaService.crearListaUsuario(listaID, usuarioID);
        return "redirect:/lista/" + this.listaService.obtenerNombre(listaID) + "/";
    }

    @GetMapping("/{listaID}/borrarLista")
    public String doBorrarLista (@PathVariable("listaID") Integer listaID) {
        String listaNombre = this.listaService.obtenerNombre(listaID);
        this.listaService.borrarLista(listaID);
        return "redirect:/lista/" + listaNombre + "/";
    }

    @PostMapping("/{listaNombre}/crearCorreoLista")
    public String doCrearCorreoLista (@PathVariable("listaNombre") String listaNombre, @RequestParam("mensajePromo") String mensajePromo, @RequestParam("productoSeleccionado") Integer productoSeleccionado) {
        this.correoService.crearCorreoLista(listaNombre, mensajePromo, productoSeleccionado);
        return "redirect:/lista/" + listaNombre + "/";
    }
}
