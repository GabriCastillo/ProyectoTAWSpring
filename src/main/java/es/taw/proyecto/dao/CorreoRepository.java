/*
    User: Javier
    Percentage: 100%
 */

package es.taw.proyecto.dao;

import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.Correo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorreoRepository extends JpaRepository<Correo, Integer> {
    public List<Correo> findCorreoByIdUsuario(Integer usuarioID);
}
