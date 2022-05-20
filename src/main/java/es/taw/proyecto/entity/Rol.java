package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Rol {
    private Long id;
    private Integer idRol;
    private String nombre;
    private List<Usuario> usuariosByIdRol;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID_ROL", nullable = false)
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(idRol, rol.idRol) && Objects.equals(nombre, rol.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, nombre);
    }

    @OneToMany(mappedBy = "rolByRolIdrol")
    public List<Usuario> getUsuariosByIdRol() {
        return usuariosByIdRol;
    }

    public void setUsuariosByIdRol(List<Usuario> usuariosByIdRol) {
        this.usuariosByIdRol = usuariosByIdRol;
    }
}
