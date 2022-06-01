package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadistica", schema = "proyectotaw")
public class EstadisticaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDESTADISTICA",nullable = false)
    private int idestadistica;
    @Basic
    @Column(name = "NOMBRE",nullable = false,length = 255)
    private String nombre;
    @Basic
    @Column(name = "DESCRIPCION",nullable = false,length = 255)
    private String descripcion;
    @Basic
    @Column(name = "VALOR")
    private Double valor;

    public int getIdestadistica() {
        return idestadistica;
    }

    public void setIdestadistica(int idestadistica) {
        this.idestadistica = idestadistica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadisticaEntity that = (EstadisticaEntity) o;
        return idestadistica == that.idestadistica && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idestadistica, nombre, descripcion, valor);
    }
}
