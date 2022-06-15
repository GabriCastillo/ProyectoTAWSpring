/**
 NAME: Ruben
 Done: 100%
 */
package es.taw.proyecto.service;

import es.taw.proyecto.dao.FavoritoRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.CategoriaDTO;
import es.taw.proyecto.dto.FavoritoDTO;
import es.taw.proyecto.entity.Categoria;
import es.taw.proyecto.entity.ProductosFavoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritoService {
    protected UsuarioRepository usuarioRepository;
    @Autowired
    private void setUsuarioRepository(UsuarioRepository usuarioRepository){this.usuarioRepository=usuarioRepository;}
    protected FavoritoRepository favoritoRepository;
    @Autowired
    private void setFavoritoRepository(FavoritoRepository favoritoRepository){this.favoritoRepository=favoritoRepository;}
    public List<FavoritoDTO> toDTO (List<ProductosFavoritos> favoritos) {
        List<FavoritoDTO> DTO = new ArrayList<>();
        for(ProductosFavoritos favorito : favoritos) {
            DTO.add(favorito.toDTO());
        }
        return DTO;
    }
    public List<FavoritoDTO> findAll(){
        return this.toDTO(this.favoritoRepository.findAll());
    }
    public void anadirfavorito(String iduser,String idproducto){
        ProductosFavoritos favorito = new ProductosFavoritos();
        favorito.setProductoIdproducto(Integer.parseInt(idproducto));
        favorito.setUsuarioComprador(Integer.parseInt(iduser));
        favorito.setUsuarioByUsuarioComprador(this.usuarioRepository.getById(Integer.parseInt(iduser)));
        this.favoritoRepository.save(favorito);
    }
    public void quitarfavorito(String iduser,String idproducto){
        ProductosFavoritos favorito = this.favoritoRepository.findProductosFavoritosByProductoIdproductoAndUsuarioComprador(Integer.parseInt(idproducto),Integer.parseInt(iduser));
        this.favoritoRepository.delete(favorito);

    }
    public List<FavoritoDTO> misfavoritos(String user){
        return this.toDTO(this.favoritoRepository.findProductosFavoritosByUsuarioComprador(Integer.parseInt(user)));
    }
}
