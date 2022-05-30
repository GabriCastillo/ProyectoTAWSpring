package es.taw.proyecto.controller;

import es.taw.proyecto.dao.CategoriaRepository;
import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.ListaRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.Categoria;
import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.Lista;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("marketing")
public class MarketingController {
    protected ListaRepository listaRepository;
    protected CompradorProductoRepository compradorProductoRepository;
    protected UsuarioRepository usuarioRepository;
    protected CategoriaRepository categoriaRepository;


    public ListaRepository getListaRepository() {
        return this.listaRepository;
    }

    @Autowired
    public void setListaRepository(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    public CompradorProductoRepository getCompradorProductoRepository() {
        return this.compradorProductoRepository;
    }

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return this.usuarioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public CategoriaRepository getCategoriaRepository() {
        return this.categoriaRepository;
    }

    @Autowired
    public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/")
    public String doListar (Model model, @RequestParam(value = "filtroListaAll", required = false) String filtroListaAll, @RequestParam(value = "filtroCompradorAll", required = false) String filtroCompradorAll) {
        List<Lista> nombresListas = new ArrayList<>();
        if((filtroListaAll == null) || filtroListaAll.equals("")) {
            nombresListas = this.listaRepository.findAll();
        } else {
            nombresListas = this.listaRepository.findListaByNombre(filtroListaAll);
        }
        model.addAttribute("nombresListas", nombresListas);

        List<Usuario> usuarios;
        List<CompradorProducto> compradoresProductos = this.compradorProductoRepository.findAll();
        List<UsuarioDTO> compradores = new ArrayList<>();
        List<Categoria> ultimasCategorias = new ArrayList<>();
        if((filtroCompradorAll == null) || filtroCompradorAll.equals("")) {
            usuarios = this.usuarioRepository.findAll();
        } else {
            usuarios = this.usuarioRepository.findUsuarioByNombre(filtroCompradorAll);
        }
        for(Usuario usuario : usuarios) {
            for(CompradorProducto compradorProducto : compradoresProductos) {
                if((compradorProducto.getUsuarioComprador() != null) && compradorProducto.getUsuarioComprador().equals(usuario.getIdusuario())) {
                    if(!compradores.contains(usuario.toDTO())) {
                        compradores.add(usuario.toDTO());
                        ultimasCategorias.add(this.categoriaRepository.findById(compradorProducto.getProductoByProductoIdproducto().getCategoriaIdcategoria()).orElse(null));
                    }
                }
            }
        }
        model.addAttribute("usuarios", compradores);
        model.addAttribute("ultimasCategorias", ultimasCategorias);

        return "listas";
    }
/*
    @GetMapping("/{id}/edit")
    public String doEditar (@PathVariable("id") Integer customerID,
                            Model model) {
        Customer cliente = this.customerRepository.findById(customerID).orElse(null);
        List<MicroMarket> listaSupers = this.microMarketRepository.findAll();
        model.addAttribute("cliente", cliente.toDTO());
        model.addAttribute("supermercados", listaSupers);
        return "cliente";
    }

    @GetMapping("/{id}/delete")
    public String doBorrar (@PathVariable("id") Integer customerID) {
        this.customerRepository.deleteById(customerID);
        return "redirect:/customer/";
    }

    @PostMapping("/save")
    public String doGuardar (@ModelAttribute("cliente") CustomerDTO cliente) {
        Customer clienteEntidad = new Customer(cliente);
        MicroMarket mm = this.microMarketRepository.getById(cliente.getSupermercadoId());
        clienteEntidad.setMicroMarketByZip(mm);
        //this.customerRepository.save(clienteEntidad); !! No funciona porque hay que añadir el código de descuento
        return "redirect:/customer/";
    }

*/
}
