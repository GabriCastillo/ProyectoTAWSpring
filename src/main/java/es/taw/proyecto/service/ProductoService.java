package es.taw.proyecto.service;

import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.ProductoRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.ProductoDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.Producto;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {
    protected UsuarioRepository usuarioRepository;
    protected CompradorProductoRepository compradorProductoRepository;
    protected ProductoRepository productoRepository;

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> toDTO (List<Producto> productos) {
        List<ProductoDTO> DTO = new ArrayList<>();
        for(Producto producto : productos) {
            DTO.add(producto.toDTO());
        }
        return DTO;
    }

    public List<ProductoDTO> listarProductosDisponibles() {
        List<Producto> productos = new ArrayList<>();
        List<CompradorProducto> compradoresProductosCompradorless = this.compradorProductoRepository.findCompradorProductoByUsuarioByUsuarioCompradorIsNull();

        if(!compradoresProductosCompradorless.isEmpty()) {
            for(CompradorProducto compradorProductoCompradorless : compradoresProductosCompradorless) {
                productos.add(this.productoRepository.findById(compradorProductoCompradorless.getProductoIdproducto()).orElse(null));
            }
            return this.toDTO(productos);
        }

        return null;
    }
}
