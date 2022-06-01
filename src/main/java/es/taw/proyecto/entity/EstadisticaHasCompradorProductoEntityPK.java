package es.taw.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EstadisticaHasCompradorProductoEntityPK implements Serializable {
    @Column(name = "COMPRADOR_PRODUCTO_IDCOMPRA",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compradorProductoIdcompra;
    @Column(name = "ESTADISTICA_IDESTADISTICA",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        EstadisticaHasCompradorProductoEntityPK that = (EstadisticaHasCompradorProductoEntityPK) o;
        return compradorProductoIdcompra == that.compradorProductoIdcompra && estadisticaIdestadistica == that.estadisticaIdestadistica;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compradorProductoIdcompra, estadisticaIdestadistica);
    }
}
