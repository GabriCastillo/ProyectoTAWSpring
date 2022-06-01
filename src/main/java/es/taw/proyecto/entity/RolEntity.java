package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rol", schema = "proyectotaw")
public class RolEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_ROL",nullable = false)
    private int idRol;
    @Basic
    @Column(name = "NOMBRE",nullable = false,length = 45)
    private String nombre;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
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
        RolEntity rolEntity = (RolEntity) o;
        return idRol == rolEntity.idRol && Objects.equals(nombre, rolEntity.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRol, nombre);
    }
}
