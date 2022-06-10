/*
    User: Javier
    Percentage: 100%
 */

package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
    public List<Lista> findListaByNombre(String nombre);

    @Modifying
    @Transactional
    @Query("delete from Lista l where l.nombre = :nombreListaBorrar")
    void deleteListaByNombre(String nombreListaBorrar);
}
