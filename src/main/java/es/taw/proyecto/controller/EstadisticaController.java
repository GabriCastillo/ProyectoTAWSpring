/*
    User: Jose
    Percentage: 100%
 */

package es.taw.proyecto.controller;

import es.taw.proyecto.dto.EstadisticaDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.service.EstadisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("analista")

public class EstadisticaController {
    protected EstadisticaService estadisticaService;
    @Autowired
    public void setEstadisticaService(EstadisticaService estadisticaService){this.estadisticaService=estadisticaService;}

    @GetMapping("/")
    public String inicio(Model model, HttpSession session, @RequestParam(value = "findByName", required = false) String filtroTitulo){

        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");
        model.addAttribute("usuario", user);

        List<EstadisticaDTO> estadisticas = this.estadisticaService.listaEstadisticas(filtroTitulo);
        model.addAttribute("estadisticas", estadisticas);


        return "Analista";
    }

    @GetMapping("/analisis")
    public String llamada(Model model, HttpSession session){
        EstadisticaDTO estadisticaDTO = new EstadisticaDTO();
        UsuarioDTO user =(UsuarioDTO) session.getAttribute("usuario");
        model.addAttribute("usuario", user);
        model.addAttribute("estadistica", estadisticaDTO);

        return "Analisis";
    }

    @PostMapping("/guardar")
    public String crear(Model model, HttpSession session, @ModelAttribute("estadistica")EstadisticaDTO estadistica){
        this.estadisticaService.save(estadistica);


        return "redirect:/analista/";
    }

    @GetMapping("/{id}/borrarEstadistica")
    public String doDeleteProducto(@PathVariable("id") String productoID) {
        this.estadisticaService.borrar(Integer.parseInt(productoID));

        return "redirect:/analista/";
    }




}
