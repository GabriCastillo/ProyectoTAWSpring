package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ESTADISTICA_HAS_COMPRADOR_PRODUCTO", schema = "TAW")
@IdClass(EstadisticaHasCompradorProductoPK.class)
public class EstadisticaHasCompradorProducto {
    private Long id;
    private Integer compradorProductoIdcompra;
    private Integer estadisticaIdestadistica;
    private CompradorProducto compradorProductoByCompradorProductoIdcompra;
    private Estadistica estadisticaByEstadisticaIdestadistica;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @ManyToOne
    @JoinColumn(name = "COMPRADOR_PRODUCTO_IDCOMPRA", referencedColumnName = "IDCOMPRA", nullable = false)
    public CompradorProducto getCompradorProductoByCompradorProductoIdcompra() {
        return compradorProductoByCompradorProductoIdcompra;
    }

    public void setCompradorProductoByCompradorProductoIdcompra(CompradorProducto compradorProductoByCompradorProductoIdcompra) {
        this.compradorProductoByCompradorProductoIdcompra = compradorProductoByCompradorProductoIdcompra;
    }

    @ManyToOne
    @JoinColumn(name = "ESTADISTICA_IDESTADISTICA", referencedColumnName = "IDESTADISTICA", nullable = false)
    public Estadistica getEstadisticaByEstadisticaIdestadistica() {
        return estadisticaByEstadisticaIdestadistica;
    }

    public void setEstadisticaByEstadisticaIdestadistica(Estadistica estadisticaByEstadisticaIdestadistica) {
        this.estadisticaByEstadisticaIdestadistica = estadisticaByEstadisticaIdestadistica;
    }
}
