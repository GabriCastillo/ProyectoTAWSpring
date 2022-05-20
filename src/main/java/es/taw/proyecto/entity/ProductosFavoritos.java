package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTOS_FAVORITOS", schema = "TAW")
public class ProductosFavoritos {
    private Long id;
    private Integer idfavorito;
    private Integer usuarioComprador;
    private Integer productoIdproducto;
    private List<EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritosByIdfavorito;
    private Usuario usuarioByUsuarioComprador;
    private Producto productoByProductoIdproducto;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "IDFAVORITO", nullable = false)
    public Integer getIdfavorito() {
        return idfavorito;
    }

    public void setIdfavorito(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    @Basic
    @Column(name = "USUARIO_COMPRADOR", nullable = false)
    public Integer getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Integer usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    @Basic
    @Column(name = "PRODUCTO_IDPRODUCTO", nullable = false)
    public Integer getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Integer productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosFavoritos that = (ProductosFavoritos) o;
        return Objects.equals(idfavorito, that.idfavorito) && Objects.equals(usuarioComprador, that.usuarioComprador) && Objects.equals(productoIdproducto, that.productoIdproducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfavorito, usuarioComprador, productoIdproducto);
    }

    @OneToMany(mappedBy = "productosFavoritosByProductosFavoritosId")
    public List<EstadisticaHasProductosFavoritos> getEstadisticaHasProductosFavoritosByIdfavorito() {
        return estadisticaHasProductosFavoritosByIdfavorito;
    }

    public void setEstadisticaHasProductosFavoritosByIdfavorito(List<EstadisticaHasProductosFavoritos> estadisticaHasProductosFavoritosByIdfavorito) {
        this.estadisticaHasProductosFavoritosByIdfavorito = estadisticaHasProductosFavoritosByIdfavorito;
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO", nullable = false)
    public Usuario getUsuarioByUsuarioComprador() {
        return usuarioByUsuarioComprador;
    }

    public void setUsuarioByUsuarioComprador(Usuario usuarioByUsuarioComprador) {
        this.usuarioByUsuarioComprador = usuarioByUsuarioComprador;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO", nullable = false)
    public Producto getProductoByProductoIdproducto() {
        return productoByProductoIdproducto;
    }

    public void setProductoByProductoIdproducto(Producto productoByProductoIdproducto) {
        this.productoByProductoIdproducto = productoByProductoIdproducto;
    }
}
