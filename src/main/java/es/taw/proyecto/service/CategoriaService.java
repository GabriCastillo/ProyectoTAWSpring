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


}
