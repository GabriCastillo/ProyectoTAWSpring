package es.taw.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EstadisticaHasCompradorProductoPK implements Serializable {
    private Integer compradorProductoIdcompra;
    private Integer estadisticaIdestadistica;

    @Column(name = "COMPRADOR_PRODUCTO_IDCOMPRA", nullable = false)
    @Id
    public Integer getCompradorProductoIdcompra() {
        return compradorProductoIdcompra;
    }

    public void setCompradorProductoIdcompra(Integer compradorProductoIdcompra) {
        this.compradorProductoIdcompra = compradorProductoIdcompra;
    }

    @Column(name = "ESTADISTICA_IDESTADISTICA", nullable = false)
    @Id
    public Integer getEstadisticaIdestadistica() {
        return estadisticaIdestadistica;
    }

    public void setEstadisticaIdestadistica(Integer estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadisticaHasCompradorProductoPK that = (EstadisticaHasCompradorProductoPK) o;
        return Objects.equals(compradorProductoIdcompra, that.compradorProductoIdcompra) && Objects.equals(estadisticaIdestadistica, that.estadisticaIdestadistica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compradorProductoIdcompra, estadisticaIdestadistica);
    }
}
