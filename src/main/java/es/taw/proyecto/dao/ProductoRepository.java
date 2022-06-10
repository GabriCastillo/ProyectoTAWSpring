package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Producto;
import es.taw.proyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {


    @Query("SELECT p FROM Producto p WHERE p.titulo LIKE CONCAT('%', :titulo, '%')")
    List<Producto> findBySimilarTitulo(@Param("titulo") String t);

    List<Producto> findProductosByTitulo(String t);

    Producto findProductoByIdproducto(int i);
}