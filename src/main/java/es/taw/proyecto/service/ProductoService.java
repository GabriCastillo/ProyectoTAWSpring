/*
    User: Javier
    Percentage: 100%
 */

package es.taw.proyecto.service;

import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.ProductoRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.CompradorProductoDTO;
import es.taw.proyecto.dto.FavoritoDTO;
import es.taw.proyecto.dto.ProductoDTO;
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

    public List<ProductoDTO> findAll(){
        return this.toDTO(this.productoRepository.findAll());
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
    public List<ProductoDTO> filtro(String titulo, String categoria) {
        if (titulo.equals("") || titulo.isEmpty()) {
            if (categoria == null || categoria.isEmpty()) {
                return this.findAll();
            } else {
                List<Producto> dto = this.productoRepository.findProductoByCategoriaIdcategoria(Integer.parseInt(categoria));
                return this.toDTO(dto);
            }
        } else {
            if (categoria == null || categoria.isEmpty()) {
                return this.toDTO(this.productoRepository.findProductoByTitulo(titulo));
            } else {
                return this.toDTO(this.productoRepository.findProductoByTituloAndAndCategoriaIdcategoria(titulo, Integer.parseInt(categoria)));

            }

        }
    }
    public List<ProductoDTO> misfavoritos(List<FavoritoDTO> favoritos){
        List<Producto> lista= new ArrayList<Producto>();
        for (FavoritoDTO favorito:favoritos){
            lista.add(this.productoRepository.getById(favorito.getProductoIdproducto()));
        }
        return this.toDTO(lista);
    }
    public List<ProductoDTO> filtroFavorito(String titulo, String categoria, List<FavoritoDTO> favoritos) {
        List<Producto> lista= new ArrayList<>();
        for(FavoritoDTO favorito: favoritos) {
            if (titulo.equals("") || titulo.isEmpty()) {
                if (categoria == null || categoria.isEmpty()) {
                    lista.add(this.productoRepository.getById(favorito.getProductoIdproducto()));
                } else {
                    Producto dto = this.productoRepository.findProductoByCategoriaIdcategoriaAndIdproducto(Integer.parseInt(categoria),favorito.getProductoIdproducto());
                    if (dto!=null){
                        lista.add(dto);
                    }

                }
            } else {
                if (categoria == null || categoria.isEmpty()) {
                    Producto dto = this.productoRepository.findProductoByTituloAndIdproducto(titulo, favorito.getProductoIdproducto());
                    if (dto!=null){
                        lista.add(dto);
                    }
                } else {
                    Producto dto = this.productoRepository.findProductoByTituloAndAndCategoriaIdcategoriaAndIdproducto(titulo, Integer.parseInt(categoria), favorito.getProductoIdproducto());
                    if (dto!=null){
                        lista.add(dto);
                    }

                }

            }
        }
        return this.toDTO(lista);
    }
}
