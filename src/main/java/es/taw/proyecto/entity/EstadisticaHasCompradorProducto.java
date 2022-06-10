package es.taw.proyecto.entity;

import javax.persistence.*;

@Entity
@Table(name = "estadistica_has_comprador_producto", schema = "proyectotaw")
@IdClass(EstadisticaHasCompradorProductoPK.class)
public class EstadisticaHasCompradorProducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "COMPRADOR_PRODUCTO_IDCOMPRA", nullable = false)
    private Integer compradorProductoIdcompra;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ESTADISTICA_IDESTADISTICA", nullable = false)
    private Integer estadisticaIdestadistica;

    public Integer getCompradorProductoIdcompra() {
        return compradorProductoIdcompra;
    }

    public void setCompradorProductoIdcompra(Integer compradorProductoIdcompra) {
        this.compradorProductoIdcompra = compradorProductoIdcompra;
    }

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

        EstadisticaHasCompradorProducto that = (EstadisticaHasCompradorProducto) o;

        if (compradorProductoIdcompra != null ? !compradorProductoIdcompra.equals(that.compradorProductoIdcompra) : that.compradorProductoIdcompra != null)
            return false;
        if (estadisticaIdestadistica != null ? !estadisticaIdestadistica.equals(that.estadisticaIdestadistica) : that.estadisticaIdestadistica != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = compradorProductoIdcompra != null ? compradorProductoIdcompra.hashCode() : 0;
        result = 31 * result + (estadisticaIdestadistica != null ? estadisticaIdestadistica.hashCode() : 0);
        return result;
    }
}