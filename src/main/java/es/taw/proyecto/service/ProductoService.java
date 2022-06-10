package es.taw.proyecto.service;

import es.taw.proyecto.dao.CategoriaRepository;
import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.ProductoRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.ProductoDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    protected UsuarioRepository usuarioRepository;
    protected CompradorProductoRepository compradorProductoRepository;
    protected ProductoRepository productoRepository;
    protected CategoriaRepository categoriaRepository;

    public CategoriaRepository getCategoriaRepository() {
        return categoriaRepository;
    }

    @Autowired
    public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

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

    public List<ProductoDTO> toDTO(List<Producto> productos) {
        List<ProductoDTO> DTO = new ArrayList<>();
        for (Producto producto : productos) {
            DTO.add(producto.toDTO());
        }
        return DTO;
    }

    public List<ProductoDTO> listarProductosDisponibles() {
        List<Producto> productos = new ArrayList<>();
        List<CompradorProducto> compradoresProductosCompradorless = this.compradorProductoRepository.findCompradorProductoByUsuarioByUsuarioCompradorIsNull();

        if (!compradoresProductosCompradorless.isEmpty()) {
            for (CompradorProducto compradorProductoCompradorless : compradoresProductosCompradorless) {
                productos.add(this.productoRepository.findById(compradorProductoCompradorless.getProductoIdproducto()).orElse(null));
            }
            return this.toDTO(productos);
        }

        return null;
    }

    public List<ProductoDTO> FiltrarTitulo(String filtroTitulo) {
        List<Producto> productoList;
        Boolean titulo = !((filtroTitulo == null) || (filtroTitulo.isEmpty()));
        if (!titulo) {
            productoList = this.productoRepository.findAll();
        } else {
            productoList = this.productoRepository.findBySimilarTitulo(filtroTitulo);
        }
        return this.toDTO(productoList);
    }

    public List<ProductoDTO> asignarCategoria(List<ProductoDTO> productos) {
        List<ProductoDTO> productoDTOList = new ArrayList<>();

        for (ProductoDTO p : productos) {
            p.setCategoriaDTO(this.categoriaRepository.findByIdCategoria(p.getCategoriaIdcategoria()).toDTO());
            productoDTOList.add(p);
        }

        return productoDTOList;
    }

    public ProductoDTO findByID(int parseInt) {
        Producto producto;
        producto = this.productoRepository.findProductoByIdproducto(parseInt);
        return producto.toDTO();
    }

    public ProductoDTO asignarRolEntity(ProductoDTO productoDTO) {

        productoDTO.setCategoriaDTO(this.categoriaRepository.findByIdCategoria(productoDTO.getCategoriaIdcategoria()).toDTO());
        return productoDTO;
    }

    public void save(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.edit(productoDTO);
        this.productoRepository.save(producto);
    }

    public void borrar(int parseInt) {
        Producto producto = this.productoRepository.findProductoByIdproducto(parseInt);
        this.productoRepository.delete(producto);
    }
}
