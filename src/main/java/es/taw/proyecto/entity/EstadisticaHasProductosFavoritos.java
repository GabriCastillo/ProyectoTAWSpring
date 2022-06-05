package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadistica_has_productos_favoritos", schema = "proyectotaw", catalog = "")
public class EstadisticaHasProductosFavoritos {
    private Long id;
    private Integer estadisticaIdestadistica;
    private Estadistica estadisticaByEstadisticaIdestadistica;
    private ProductosFavoritos productosFavoritosByProductosFavoritosId;


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
        EstadisticaHasProductosFavoritos that = (EstadisticaHasProductosFavoritos) o;
        return Objects.equals(estadisticaIdestadistica, that.estadisticaIdestadistica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadisticaIdestadistica);
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
