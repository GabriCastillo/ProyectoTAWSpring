package es.taw.proyecto.entity;

import javax.persistence.*;

@Entity
@Table(name = "estadistica_has_productos_favoritos", schema = "proyectotaw")
public class EstadisticaHasProductosFavoritos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ESTADISTICA_IDESTADISTICA", nullable = false)
    private Integer estadisticaIdestadistica;
    @Basic
    @Column(name = "PRODUCTOS_FAVORITOS_ID", nullable = false)
    private Integer productosFavoritosId;
    @OneToOne
    @JoinColumn(name = "ESTADISTICA_IDESTADISTICA", referencedColumnName = "IDESTADISTICA", nullable = false)
    private Estadistica estadisticaByEstadisticaIdestadistica;
    @ManyToOne
    @JoinColumn(name = "PRODUCTOS_FAVORITOS_ID", referencedColumnName = "IDFAVORITO", nullable = false, insertable = false, updatable = false)
    private ProductosFavoritos productosFavoritosByProductosFavoritosId;

    public Integer getEstadisticaIdestadistica() {
        return estadisticaIdestadistica;
    }

    public void setEstadisticaIdestadistica(Integer estadisticaIdestadistica) {
        this.estadisticaIdestadistica = estadisticaIdestadistica;
    }

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

        if (estadisticaIdestadistica != null ? !estadisticaIdestadistica.equals(that.estadisticaIdestadistica) : that.estadisticaIdestadistica != null)
            return false;
        if (productosFavoritosId != null ? !productosFavoritosId.equals(that.productosFavoritosId) : that.productosFavoritosId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = estadisticaIdestadistica != null ? estadisticaIdestadistica.hashCode() : 0;
        result = 31 * result + (productosFavoritosId != null ? productosFavoritosId.hashCode() : 0);
        return result;
    }

    public Estadistica getEstadisticaByEstadisticaIdestadistica() {
        return estadisticaByEstadisticaIdestadistica;
    }

    public void setEstadisticaByEstadisticaIdestadistica(Estadistica estadisticaByEstadisticaIdestadistica) {
        this.estadisticaByEstadisticaIdestadistica = estadisticaByEstadisticaIdestadistica;
    }

    public ProductosFavoritos getProductosFavoritosByProductosFavoritosId() {
        return productosFavoritosByProductosFavoritosId;
    }

    public void setProductosFavoritosByProductosFavoritosId(ProductosFavoritos productosFavoritosByProductosFavoritosId) {
        this.productosFavoritosByProductosFavoritosId = productosFavoritosByProductosFavoritosId;
    }
}
