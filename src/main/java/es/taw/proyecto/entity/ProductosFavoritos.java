package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productos_favoritos", schema = "proyectotaw")
public class ProductosFavoritos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDFAVORITO", nullable = false)
    private Integer idfavorito;
    @Basic
    @Column(name = "USUARIO_COMPRADOR", nullable = false)
    private Integer usuarioComprador;
    @Basic
    @Column(name = "PRODUCTO_IDPRODUCTO", nullable = false)
    private Integer productoIdproducto;
    @ManyToOne
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO", nullable = false, insertable = false, updatable = false)
    private Usuario usuarioByUsuarioComprador;

    public Integer getIdfavorito() {
        return idfavorito;
    }

    public void setIdfavorito(Integer idfavorito) {
        this.idfavorito = idfavorito;
    }

    public Integer getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Integer usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

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

        if (idfavorito != null ? !idfavorito.equals(that.idfavorito) : that.idfavorito != null) return false;
        if (usuarioComprador != null ? !usuarioComprador.equals(that.usuarioComprador) : that.usuarioComprador != null)
            return false;
        if (productoIdproducto != null ? !productoIdproducto.equals(that.productoIdproducto) : that.productoIdproducto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idfavorito != null ? idfavorito.hashCode() : 0;
        result = 31 * result + (usuarioComprador != null ? usuarioComprador.hashCode() : 0);
        result = 31 * result + (productoIdproducto != null ? productoIdproducto.hashCode() : 0);
        return result;
    }

    public Usuario getUsuarioByUsuarioComprador() {
        return usuarioByUsuarioComprador;
    }

    public void setUsuarioByUsuarioComprador(Usuario usuarioByUsuarioComprador) {
        this.usuarioByUsuarioComprador = usuarioByUsuarioComprador;
    }
}
