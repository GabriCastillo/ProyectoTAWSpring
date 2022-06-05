package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, String> {

    Rol findByIdRol(Integer r);
}
