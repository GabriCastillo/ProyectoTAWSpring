package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Categoria findByIdCategoria(Integer c);

    List<Categoria> findCategoriasByTipo(String t);

}
