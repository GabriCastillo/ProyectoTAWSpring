/*
    User: Jose
    Percentage: 100%
 */

package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Estadistica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Integer> {
    public List<Estadistica> findEstadisticaByNombre(String nombre);
    public List<Estadistica> findEstadisticaByUsuarioAnalista(Integer usuarioAnalista);

    @Query("SELECT c FROM Estadistica c WHERE c.nombre LIKE CONCAT('%', :titulo, '%')")
    List<Estadistica> findBySimilarTitulo(@Param("titulo") String t);
    Estadistica findEstadisticaByIdestadistica(int i);
}
