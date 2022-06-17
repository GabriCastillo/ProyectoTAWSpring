

package es.taw.proyecto.service;

import es.taw.proyecto.dao.CategoriaRepository;
import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dto.CategoriaDTO;
import es.taw.proyecto.dto.ListaDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.Categoria;
import es.taw.proyecto.entity.CompradorProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 NAME: Gabriel Castillo, Javier Rueda
 Done: 20%, 80%
 */
@Service
public class CategoriaService {
    protected CompradorProductoRepository compradorProductoRepository;
    protected CategoriaRepository categoriaRepository;

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }

    @Autowired
    public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> toDTO (List<Categoria> categorias) {
        List<CategoriaDTO> DTO = new ArrayList<>();
        for(Categoria categoria : categorias) {
            DTO.add(categoria.toDTO());
        }
        return DTO;
    }

    public List<CategoriaDTO> listarCategoriasUltimas (List<UsuarioDTO> compradores) {
        List<Categoria> categorias = new ArrayList<>();
        List<CompradorProducto> compradoresProductosAll = this.compradorProductoRepository.findAll();

        if((compradores != null) && !compradoresProductosAll.isEmpty()) {
            List<CompradorProducto> compradoresProductosAux = new ArrayList<>();

            for(UsuarioDTO comprador : compradores) {
                for(CompradorProducto compradorProducto : compradoresProductosAll) {
                    if((compradorProducto.getUsuarioComprador() != null) && compradorProducto.getUsuarioComprador().equals(comprador.getIdusuario())) {
                        compradoresProductosAux.add(compradorProducto);
                    }
                }
                categorias.add(this.categoriaRepository.findById(compradoresProductosAux.get(compradoresProductosAux.size() - 1).getProductoByProductoIdproducto().getCategoriaIdcategoria()).orElse(null));
                compradoresProductosAux.clear();
            }

            return this.toDTO(categorias);
        }

        return null;
    }

    public List<CategoriaDTO> listarCategoriasUltimasLista (List<ListaDTO> listas) {
        if((listas != null) && (listas.get(0).getUsuarioByUsuarioLista() != null)) {
            List<UsuarioDTO> compradores = new ArrayList<>();
            for(ListaDTO lista : listas) {
                compradores.add(lista.getUsuarioByUsuarioLista().toDTO());
            }
            return this.listarCategoriasUltimas(compradores);
        }

        return null;
    }

    public List<CategoriaDTO> listarCategorias(String tipo) {

        List<Categoria> categoria;
        Boolean titulo = !((tipo == null) || (tipo.isEmpty()));
        if (!titulo) {
            categoria = this.categoriaRepository.findAll();
        } else {
            categoria = this.categoriaRepository.findBySimilarTipo(tipo);
        }
        return this.toDTO(categoria);
    }
    public  List<CategoriaDTO> findall(){
        return this.toDTO(this.categoriaRepository.findAll());
    }
    public CategoriaDTO findByID(int parseInt) {
        return this.categoriaRepository.findByIdCategoria(parseInt).toDTO();
    }

    public Categoria findCategoriaByID(Integer idCategoria) {
        Categoria categoria;
        categoria = this.categoriaRepository.findByIdCategoria(idCategoria);
        return categoria;
    }

    public void save(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.edit(categoriaDTO);
        this.categoriaRepository.save(categoria);
    }

    public void borrar(int parseInt) {
        Categoria categoria = this.categoriaRepository.findByIdCategoria(parseInt);
        this.categoriaRepository.delete(categoria);
    }
    public Integer buscarPorNombre(String nombreCategoria) {
        Categoria categoria = this.categoriaRepository.findByTipo(nombreCategoria);
        return categoria.getIdCategoria();
    }
}
