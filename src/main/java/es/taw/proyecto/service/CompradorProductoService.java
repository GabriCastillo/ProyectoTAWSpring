package es.taw.proyecto.service;

import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.ProductoRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.CompradorProductoDTO;
import es.taw.proyecto.dto.ProductoSubastaDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.Producto;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompradorProductoService {

    protected CompradorProductoRepository compradorProductoRepository;
    protected UsuarioRepository usuarioRepository;

    protected ProductoRepository productoRepository;

    protected CategoriaService categoriaService;

    @Autowired
    public void  setCategoriaService(CategoriaService categoriaService){
        this.categoriaService=categoriaService;
    }

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository){
        this.compradorProductoRepository=compradorProductoRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    public List<CompradorProductoDTO> listarSubastasVendedor(UsuarioDTO user){
        Usuario usuario = this.usuarioRepository.findByIdusuario(user.getIdusuario());
        List<CompradorProducto> subastas = this.compradorProductoRepository.findByUsuarioByUsuarioVendedor(usuario);
        return this.listarSubastasToDTO(subastas);
    }

    private List<CompradorProductoDTO> listarSubastasToDTO(List<CompradorProducto> subastas){
        List<CompradorProductoDTO> subastasDTO = new ArrayList<>();
        for(CompradorProducto cp: subastas){
            subastasDTO.add(cp.toDTO());
        }
        return subastasDTO;
    }

    public void cerrarSubasta(Integer idsubasta){
        CompradorProducto cp = this.compradorProductoRepository.findByIdcompra(idsubasta);

        cp.setPrecioCompra(0);

        this.compradorProductoRepository.save(cp);
    }

    public void crearSubasta(ProductoSubastaDTO nuevaSubasta){
        Producto producto = new Producto();
        producto.setDescripcion(nuevaSubasta.getDescripcion());
        producto.setTitulo(nuevaSubasta.getTitulo());
        producto.setCategoriaIdcategoria(this.categoriaService.buscarPorNombre(nuevaSubasta.getNombreCategoria()));
        producto.setUrlImagen(nuevaSubasta.getUrlImagen());
        producto.setUsuarioVendedor(nuevaSubasta.getUsuarioVendedor());
        producto.setUsuarioByUsuarioVendedor(this.usuarioRepository.findByIdusuario(nuevaSubasta.getUsuarioVendedor()));

        this.productoRepository.save(producto);

        Producto p = this.productoRepository.findAll().get(this.productoRepository.findAll().lastIndexOf(producto));

        CompradorProducto compradorProducto = new CompradorProducto();
        compradorProducto.setProductoIdproducto(p.getIdproducto());
        compradorProducto.setProductoByProductoIdproducto(p);
        compradorProducto.setPrecioCompra(nuevaSubasta.getPrecioCompra());
        compradorProducto.setPrecioSalida(nuevaSubasta.getPrecioSalida());
        compradorProducto.setUsuarioByUsuarioVendedor(this.usuarioRepository.findByIdusuario(nuevaSubasta.getUsuarioVendedor()));
        compradorProducto.setUsuarioVendedor(nuevaSubasta.getUsuarioVendedor());

        this.compradorProductoRepository.save(compradorProducto);
    }
}
