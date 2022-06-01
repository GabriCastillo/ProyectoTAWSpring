package es.taw.proyecto.dao;

import es.taw.proyecto.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<RolEntity, String> {
}
