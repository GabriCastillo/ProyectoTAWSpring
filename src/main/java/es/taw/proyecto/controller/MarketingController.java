package es.taw.proyecto.controller;

import es.taw.proyecto.dao.CategoriaRepository;
import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.ListaRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.CategoriaDTO;
import es.taw.proyecto.dto.ListaDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.service.CategoriaService;
import es.taw.proyecto.service.ListaService;
import es.taw.proyecto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("marketing")
public class MarketingController {
    protected ListaService listaService;
    protected UsuarioService usuarioService;
    protected CategoriaService categoriaService;

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

    @GetMapping("/")
    public String doListar (Model model, @RequestParam(value = "filtroListaAll", required = false) String filtroListaAll, @RequestParam(value = "filtroCompradorAll", required = false) String filtroCompradorAll) {
        List<ListaDTO> nombresListas = this.listaService.listarListas(filtroListaAll);
        model.addAttribute("nombresListas", nombresListas);

        List<UsuarioDTO> compradores = this.usuarioService.listarUsuariosCompradores(this.usuarioService.listarUsuarios(filtroCompradorAll));
        List<CategoriaDTO> categoriasUltimas = this.categoriaService.listarCategoriasUltimas(compradores);

        model.addAttribute("usuarios", compradores);
        model.addAttribute("categoriasUltimas", categoriasUltimas);

        return "listas";
    }

    @PostMapping("/crearLista")
    public String doCrearLista (@RequestParam("nombreLista") String nombreLista) {
        this.listaService.crearLista(nombreLista);
        return "redirect:/marketing/";
    }

    @GetMapping("/{nombreListaBorrar}/borrarLista")
    public String doBorrarLista (@PathVariable("nombreListaBorrar") String nombreListaBorrar) {
        this.listaService.borrarLista(nombreListaBorrar);
        return "redirect:/marketing/";
    }

    @GetMapping("/{usuarioID}/editarCorreo")
    public String goToCorreo (@PathVariable("usuarioID") Integer usuarioID) {

        return "redirect:/correo/";
    }
}
