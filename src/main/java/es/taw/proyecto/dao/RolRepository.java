package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 NAME: Gabriel Castillo
 Done: 100%
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, String> {

    Rol findByIdRol(Integer r);
}
