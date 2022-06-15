package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 NAME: Gabriel Castillo
 Done: 10%
 NAME: Ruben
 Done: 25%
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    public List<Producto> findProductoByTituloAndAndCategoriaIdcategoria(String titulo,Integer categoria);
    public List<Producto> findProductoByTitulo(String titulo);
    public List<Producto> findProductoByCategoriaIdcategoria(Integer categoria);

    public Producto findProductoByTituloAndAndCategoriaIdcategoriaAndIdproducto(String titulo,Integer categoria,Integer id);
    public Producto findProductoByTituloAndIdproducto(String titulo,Integer id);
    public Producto findProductoByCategoriaIdcategoriaAndIdproducto(Integer categoria,Integer id);
    @Query("SELECT p FROM Producto p WHERE p.titulo LIKE CONCAT('%', :titulo, '%')")
    List<Producto> findBySimilarTitulo(@Param("titulo") String t);

    List<Producto> findProductosByTitulo(String t);

    Producto findProductoByIdproducto(int i);
}
