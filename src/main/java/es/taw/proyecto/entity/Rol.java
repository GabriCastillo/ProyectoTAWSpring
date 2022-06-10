package es.taw.proyecto.entity;

import es.taw.proyecto.dto.RolDTO;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Rol {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ROL", nullable = false)
    private Integer idRol;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;
    @OneToMany(mappedBy = "rolIdrol")
    private Collection<Usuario> usuariosByIdRol;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

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

        if (idRol != null ? !idRol.equals(rol.idRol) : rol.idRol != null) return false;
        if (nombre != null ? !nombre.equals(rol.nombre) : rol.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRol != null ? idRol.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    public Collection<Usuario> getUsuariosByIdRol() {
        return usuariosByIdRol;
    }

    public void setUsuariosByIdRol(Collection<Usuario> usuariosByIdRol) {
        this.usuariosByIdRol = usuariosByIdRol;
    }

    public RolDTO toDTO() {
        RolDTO DTO = new RolDTO();

        DTO.setIdRol(idRol);
        DTO.setNombre(nombre);

        return DTO;
}
}
