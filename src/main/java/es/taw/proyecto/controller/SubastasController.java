package es.taw.proyecto.controller;


import es.taw.proyecto.dto.CategoriaDTO;
import es.taw.proyecto.dto.CompradorProductoDTO;
import es.taw.proyecto.dto.ProductoSubastaDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.service.CategoriaService;
import es.taw.proyecto.service.CompradorProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("subastas")
public class SubastasController {

    private CompradorProductoService compradorProductoService;

    private CategoriaService categoriaService;

    @Autowired
    public void setCategoriaService(CategoriaService categoriaService){this.categoriaService=categoriaService;}

    @Autowired
    public void setCompradorProductoService(CompradorProductoService compradorProductoService){this.compradorProductoService=compradorProductoService;}

    @GetMapping("/")
    public String doSubastar(Model model, HttpSession  session){
        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");
        List<CompradorProductoDTO> subastas = this.compradorProductoService.listarSubastasVendedor(user);
        List<CategoriaDTO> categorias = this.categoriaService.findall();
        model.addAttribute("categorias",categorias);
        model.addAttribute("subastas",subastas);
        model.addAttribute("usuario",user);
        ProductoSubastaDTO productoSubastaDTO = new ProductoSubastaDTO();
        productoSubastaDTO.setUsuarioVendedor(user.getIdusuario());
        model.addAttribute("productoSubasta",productoSubastaDTO);
        return "MisSubastas";
    }

    @GetMapping("/cerrar/{idsubasta}")
    public String doCerrarSubasta(Model model, @PathVariable("idsubasta") Integer idsubasta){

        this.compradorProductoService.cerrarSubasta(idsubasta);
        return "redirect:/subastas/";
    }

    @PostMapping("/crear")
    public String doCrearSubasta(@ModelAttribute("productoSubastaDTO") ProductoSubastaDTO productoSubastaDTO,Model model){
        this.compradorProductoService.crearSubasta(productoSubastaDTO);

        return "redirect:/subastas/";
    }
}
