package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ESTADISTICA_HAS_PRODUCTOS_FAVORITOS", schema = "TAW")
public class EstadisticaHasProductosFavoritos {
    private Long id;
    private Integer estadisticaIdestadistica;
    private Integer productosFavoritosId;
    private Estadistica estadisticaByEstadisticaIdestadistica;
    private ProductosFavoritos productosFavoritosByProductosFavoritosId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ESTADISTICA_IDESTADISTICA", nullable = false)
    public Integer getEstadisticaIdestadistica() {
        return estadisticaIdestadistica;
    }

    public void setEstadisticaIdestadistica(Integer estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

    @Basic
    @Column(name = "PRODUCTOS_FAVORITOS_ID", nullable = false)
    public Integer getProductosFavoritosId() {
        return productosFavoritosId;
    }

    public void setProductosFavoritosId(Integer productosFavoritosId) {
        this.productosFavoritosId = productosFavoritosId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadisticaHasProductosFavoritos that = (EstadisticaHasProductosFavoritos) o;
        return Objects.equals(estadisticaIdestadistica, that.estadisticaIdestadistica) && Objects.equals(productosFavoritosId, that.productosFavoritosId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadisticaIdestadistica, productosFavoritosId);
    }

    @OneToOne
    @JoinColumn(name = "ESTADISTICA_IDESTADISTICA", referencedColumnName = "IDESTADISTICA", nullable = false)
    public Estadistica getEstadisticaByEstadisticaIdestadistica() {
        return estadisticaByEstadisticaIdestadistica;
    }

    public void setEstadisticaByEstadisticaIdestadistica(Estadistica estadisticaByEstadisticaIdestadistica) {
        this.estadisticaByEstadisticaIdestadistica = estadisticaByEstadisticaIdestadistica;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCTOS_FAVORITOS_ID", referencedColumnName = "IDFAVORITO", nullable = false)
    public ProductosFavoritos getProductosFavoritosByProductosFavoritosId() {
        return productosFavoritosByProductosFavoritosId;
    }

    public void setProductosFavoritosByProductosFavoritosId(ProductosFavoritos productosFavoritosByProductosFavoritosId) {
        this.productosFavoritosByProductosFavoritosId = productosFavoritosByProductosFavoritosId;
    }
}
