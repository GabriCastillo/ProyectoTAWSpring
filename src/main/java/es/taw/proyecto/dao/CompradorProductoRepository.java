package es.taw.proyecto.dao;

import es.taw.proyecto.entity.CompradorProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorProductoRepository extends JpaRepository<CompradorProducto, Integer> {
}
