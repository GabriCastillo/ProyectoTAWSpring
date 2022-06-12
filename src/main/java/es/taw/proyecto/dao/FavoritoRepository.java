package es.taw.proyecto.dao;

import es.taw.proyecto.entity.ProductosFavoritos;
import es.taw.proyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<ProductosFavoritos,Integer> {
    public ProductosFavoritos findProductosFavoritosByProductoIdproductoAndUsuarioComprador(Integer producto, Integer comprador);
    public List<ProductosFavoritos> findProductosFavoritosByUsuarioComprador(Integer user);
}
