package es.taw.proyecto.dao;
/*
 NAME: Gabriel Castillo
 Done: 100%
 */
import es.taw.proyecto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findByIdCategoria(Integer c);

    List<Categoria> findCategoriasByTipo(String t);

    @Query("SELECT c FROM Categoria  c WHERE c.tipo LIKE CONCAT('%', :tipo, '%')")
    List<Categoria> findBySimilarTipo(@Param("tipo") String t);
    public Categoria findByTipo(String tipo);
}
