package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "comprador_producto", schema = "proyectotaw")
public class CompradorProducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCOMPRA", nullable = false)
    private Integer idcompra;
    @Basic
    @Column(name = "PRECIO_SALIDA", nullable = false, precision = 0)
    private Integer precioSalida;
    @Basic
    @Column(name = "PRECIO_COMPRA", nullable = false, precision = 0)
    private Integer precioCompra;
    @Basic
    @Column(name = "USUARIO_COMPRADOR", nullable = true)
    private Integer usuarioComprador;
    @Basic
    @Column(name = "USUARIO_VENDEDOR", nullable = false)
    private Integer usuarioVendedor;
    @Basic
    @Column(name = "PRODUCTO_IDPRODUCTO", nullable = false)
    private Integer productoIdproducto;
    @ManyToOne
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO", insertable = false, updatable = false)
    private Usuario usuarioByUsuarioComprador;
    @ManyToOne
    @JoinColumn(name = "USUARIO_VENDEDOR", referencedColumnName = "IDUSUARIO", nullable = false, insertable = false, updatable = false)
    private Usuario usuarioByUsuarioVendedor;
    @ManyToOne
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO", nullable = false, insertable = false, updatable = false)
    private Producto productoByProductoIdproducto;
    @OneToMany(mappedBy = "compradorProductoIdcompra")
    private Collection<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdcompra;

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Integer getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(Integer precioSalida) {
        this.precioSalida = precioSalida;
    }

    public Integer getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Integer precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Integer usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    public Integer getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Integer usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
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

        CompradorProducto that = (CompradorProducto) o;

        if (idcompra != null ? !idcompra.equals(that.idcompra) : that.idcompra != null) return false;
        if (precioSalida != null ? !precioSalida.equals(that.precioSalida) : that.precioSalida != null) return false;
        if (precioCompra != null ? !precioCompra.equals(that.precioCompra) : that.precioCompra != null) return false;
        if (usuarioComprador != null ? !usuarioComprador.equals(that.usuarioComprador) : that.usuarioComprador != null)
            return false;
        if (usuarioVendedor != null ? !usuarioVendedor.equals(that.usuarioVendedor) : that.usuarioVendedor != null)
            return false;
        if (productoIdproducto != null ? !productoIdproducto.equals(that.productoIdproducto) : that.productoIdproducto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcompra != null ? idcompra.hashCode() : 0;
        result = 31 * result + (precioSalida != null ? precioSalida.hashCode() : 0);
        result = 31 * result + (precioCompra != null ? precioCompra.hashCode() : 0);
        result = 31 * result + (usuarioComprador != null ? usuarioComprador.hashCode() : 0);
        result = 31 * result + (usuarioVendedor != null ? usuarioVendedor.hashCode() : 0);
        result = 31 * result + (productoIdproducto != null ? productoIdproducto.hashCode() : 0);
        return result;
    }

    public Usuario getUsuarioByUsuarioComprador() {
        return usuarioByUsuarioComprador;
    }

    public void setUsuarioByUsuarioComprador(Usuario usuarioByUsuarioComprador) {
        this.usuarioByUsuarioComprador = usuarioByUsuarioComprador;
    }

    public Usuario getUsuarioByUsuarioVendedor() {
        return usuarioByUsuarioVendedor;
    }

    public void setUsuarioByUsuarioVendedor(Usuario usuarioByUsuarioVendedor) {
        this.usuarioByUsuarioVendedor = usuarioByUsuarioVendedor;
    }

    public Producto getProductoByProductoIdproducto() {
        return productoByProductoIdproducto;
    }

    public void setProductoByProductoIdproducto(Producto productoByProductoIdproducto) {
        this.productoByProductoIdproducto = productoByProductoIdproducto;
    }

    public Collection<EstadisticaHasCompradorProducto> getEstadisticaHasCompradorProductosByIdcompra() {
        return estadisticaHasCompradorProductosByIdcompra;
    }

    public void setEstadisticaHasCompradorProductosByIdcompra(Collection<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdcompra) {
        this.estadisticaHasCompradorProductosByIdcompra = estadisticaHasCompradorProductosByIdcompra;
    }
}
