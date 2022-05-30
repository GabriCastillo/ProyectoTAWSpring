package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findUsuarioByNombreAndPassword(String nombre, String password);

    public List<Usuario> findUsuarioByNombre(String nombre);
}
