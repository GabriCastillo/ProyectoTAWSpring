package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadistica_has_comprador_producto", schema = "proyectotaw", catalog = "")
@IdClass(EstadisticaHasCompradorProductoPK.class)
public class EstadisticaHasCompradorProducto {
    private Long id;
    private Integer compradorProductoIdcompra;
    private Integer estadisticaIdestadistica;
   // private CompradorProducto compradorProductoByCompradorProductoIdcompra;
    private Estadistica estadisticaByEstadisticaIdestadistica;



    @Id
    @Column(name = "COMPRADOR_PRODUCTO_IDCOMPRA", nullable = false)
    public Integer getCompradorProductoIdcompra() {
        return compradorProductoIdcompra;
    }

    public void setCompradorProductoIdcompra(Integer compradorProductoIdcompra) {
        this.compradorProductoIdcompra = compradorProductoIdcompra;
    }

    @Id
    @Column(name = "ESTADISTICA_IDESTADISTICA", nullable = false)
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
        return Objects.equals(compradorProductoIdcompra, that.compradorProductoIdcompra) && Objects.equals(estadisticaIdestadistica, that.estadisticaIdestadistica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compradorProductoIdcompra, estadisticaIdestadistica);
    }


}
