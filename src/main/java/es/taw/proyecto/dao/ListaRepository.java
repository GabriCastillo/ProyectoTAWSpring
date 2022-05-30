package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
    public List<Lista> findListaByNombre(String nombre);

}
