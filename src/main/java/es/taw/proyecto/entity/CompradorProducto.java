package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COMPRADOR_PRODUCTO", schema = "TAW")
public class CompradorProducto {
    private Long id;
    private Integer idcompra;
    private Integer precioSalida;
    private Integer precioCompra;
    private Integer usuarioComprador;
    private Integer usuarioVendedor;
    private Integer productoIdproducto;
    private Usuario usuarioByUsuarioComprador;
    private Usuario usuarioByUsuarioVendedor;
    private Producto productoByProductoIdproducto;
    private List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdcompra;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "IDCOMPRA", nullable = false)
    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    @Basic
    @Column(name = "PRECIO_SALIDA", nullable = false, precision = 0)
    public Integer getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(Integer precioSalida) {
        this.precioSalida = precioSalida;
    }

    @Basic
    @Column(name = "PRECIO_COMPRA", nullable = false, precision = 0)
    public Integer getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Integer precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Basic
    @Column(name = "USUARIO_COMPRADOR", nullable = true)
    public Integer getUsuarioComprador() {
        return usuarioComprador;
    }

    public void setUsuarioComprador(Integer usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    @Basic
    @Column(name = "USUARIO_VENDEDOR", nullable = false)
    public Integer getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Integer usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
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
        CompradorProducto that = (CompradorProducto) o;
        return Objects.equals(idcompra, that.idcompra) && Objects.equals(precioSalida, that.precioSalida) && Objects.equals(precioCompra, that.precioCompra) && Objects.equals(usuarioComprador, that.usuarioComprador) && Objects.equals(usuarioVendedor, that.usuarioVendedor) && Objects.equals(productoIdproducto, that.productoIdproducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcompra, precioSalida, precioCompra, usuarioComprador, usuarioVendedor, productoIdproducto);
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_COMPRADOR", referencedColumnName = "IDUSUARIO")
    public Usuario getUsuarioByUsuarioComprador() {
        return usuarioByUsuarioComprador;
    }

    public void setUsuarioByUsuarioComprador(Usuario usuarioByUsuarioComprador) {
        this.usuarioByUsuarioComprador = usuarioByUsuarioComprador;
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_VENDEDOR", referencedColumnName = "IDUSUARIO", nullable = false)
    public Usuario getUsuarioByUsuarioVendedor() {
        return usuarioByUsuarioVendedor;
    }

    public void setUsuarioByUsuarioVendedor(Usuario usuarioByUsuarioVendedor) {
        this.usuarioByUsuarioVendedor = usuarioByUsuarioVendedor;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCTO_IDPRODUCTO", referencedColumnName = "IDPRODUCTO", nullable = false)
    public Producto getProductoByProductoIdproducto() {
        return productoByProductoIdproducto;
    }

    public void setProductoByProductoIdproducto(Producto productoByProductoIdproducto) {
        this.productoByProductoIdproducto = productoByProductoIdproducto;
    }

    @OneToMany(mappedBy = "compradorProductoByCompradorProductoIdcompra")
    public List<EstadisticaHasCompradorProducto> getEstadisticaHasCompradorProductosByIdcompra() {
        return estadisticaHasCompradorProductosByIdcompra;
    }

    public void setEstadisticaHasCompradorProductosByIdcompra(List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdcompra) {
        this.estadisticaHasCompradorProductosByIdcompra = estadisticaHasCompradorProductosByIdcompra;
    }
}
