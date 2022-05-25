package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadistica_has_comprador_producto", schema = "proyectotaw", catalog = "")
@IdClass(EstadisticaHasCompradorProductoEntityPK.class)
public class EstadisticaHasCompradorProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COMPRADOR_PRODUCTO_IDCOMPRA",nullable = false)
    private int compradorProductoIdcompra;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ESTADISTICA_IDESTADISTICA",nullable = false)
    private int estadisticaIdestadistica;

    public int getCompradorProductoIdcompra() {
        return compradorProductoIdcompra;
    }

    public void setCompradorProductoIdcompra(int compradorProductoIdcompra) {
        this.compradorProductoIdcompra = compradorProductoIdcompra;
    }

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
        EstadisticaHasCompradorProductoEntity that = (EstadisticaHasCompradorProductoEntity) o;
        return compradorProductoIdcompra == that.compradorProductoIdcompra && estadisticaIdestadistica == that.estadisticaIdestadistica;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compradorProductoIdcompra, estadisticaIdestadistica);
    }
}
