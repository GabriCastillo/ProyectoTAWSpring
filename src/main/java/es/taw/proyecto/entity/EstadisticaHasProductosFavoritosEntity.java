package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadistica_has_productos_favoritos", schema = "proyectotaw")
public class EstadisticaHasProductosFavoritosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ESTADISTICA_IDESTADISTICA",nullable = false)
    private int estadisticaIdestadistica;

    public int getEstadisticaIdestadistica() {
        return estadisticaIdestadistica;
    }

    public void setEstadisticaIdestadistica(int estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadisticaHasProductosFavoritosEntity that = (EstadisticaHasProductosFavoritosEntity) o;
        return estadisticaIdestadistica == that.estadisticaIdestadistica;
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadisticaIdestadistica);
    }
}
