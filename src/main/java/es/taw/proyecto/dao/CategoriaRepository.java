package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    public Categoria findByTipo(String tipo);
}
