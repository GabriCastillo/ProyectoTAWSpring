/*
    User: Javier
    Percentage: 100%
 */

package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findUsuarioByNombreAndPassword(String nombre, String password);

    public List<Usuario> findUsuarioByNombre(String nombre);
    public Usuario findByIdusuario(Integer idusuario);
    public List<Usuario> findUsuarioByApellido(String apellido);

    public List<Usuario> findUsuarioByEdad(Integer edad);

    public List<Usuario> findUsuarioBySexo(String sexo);
    Usuario findUsuarioByIdusuario(int id);
    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE CONCAT('%', :nombre, '%')")
    List<Usuario> findBySimilarNombre(@Param("nombre") String n);

    @Query("SELECT u FROM Usuario u WHERE u.apellido LIKE CONCAT('%', :apellido, '%')")
    List<Usuario> findBySimilarApellido(@Param("apellido") String a);

    @Query("SELECT u FROM Usuario u WHERE u.rolIdrol = :rol")
    List<Usuario> findBySimilarRol(@Param("rol") int r);

    @Query("SELECT u FROM Usuario u WHERE u.apellido LIKE CONCAT('%', :apellido, '%') AND  u.rolIdrol = :rol")
    List<Usuario> findBySimilarApellidoAndRol(@Param("apellido") String a,@Param("rol") int r);

    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE CONCAT('%', :nombre, '%') AND  u.rolIdrol = :rol")
    List<Usuario> findBySimilarNombreAndRol(@Param("nombre") String n,@Param("rol") int r );

    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE CONCAT('%', :nombre, '%') AND  u.apellido LIKE CONCAT('%', :apellido, '%')")
    List<Usuario> findBySimilarNombreAndApellido(@Param("nombre") String n,@Param("apellido") String a);

    @Query("SELECT u FROM Usuario u WHERE u.nombre LIKE CONCAT('%', :nombre, '%') AND  u.apellido LIKE CONCAT('%', :apellido, '%') AND  u.rolIdrol = :rol")
    List<Usuario> findBySimilarNombreAndApellidoAndRol( @Param("nombre") String n, @Param("apellido") String a, @Param("rol") int r);

}
