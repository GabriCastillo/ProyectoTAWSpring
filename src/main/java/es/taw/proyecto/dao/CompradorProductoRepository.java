/*
    User: Javier
    Percentage: 100%
 */

package es.taw.proyecto.dao;

import es.taw.proyecto.entity.CompradorProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompradorProductoRepository extends JpaRepository<CompradorProducto, Integer> {
    public List<CompradorProducto> findCompradorProductoByUsuarioByUsuarioCompradorIsNull();
}
