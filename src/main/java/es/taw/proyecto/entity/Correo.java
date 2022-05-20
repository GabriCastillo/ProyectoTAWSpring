package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Correo {
    private Long id;
    private Integer idpromo;
    private String mensaje;
    private Integer idUsuario;
    private Integer idProducto;
    private Usuario usuarioByIdUsuario;
    private Usuario usuarioByIdUsuario_0;
    private Producto productoByIdProducto;
    private Producto productoByIdProducto_0;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "IDPROMO", nullable = false)
    public Integer getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    @Basic
    @Column(name = "MENSAJE", nullable = false, length = 300)
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Basic
    @Column(name = "ID_USUARIO", nullable = false)
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "ID_PRODUCTO", nullable = true)
    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correo correo = (Correo) o;
        return Objects.equals(idpromo, correo.idpromo) && Objects.equals(mensaje, correo.mensaje) && Objects.equals(idUsuario, correo.idUsuario) && Objects.equals(idProducto, correo.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpromo, mensaje, idUsuario, idProducto);
    }

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "IDUSUARIO", nullable = false)
    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "IDUSUARIO", nullable = false)
    public Usuario getUsuarioByIdUsuario_0() {
        return usuarioByIdUsuario_0;
    }

    public void setUsuarioByIdUsuario_0(Usuario usuarioByIdUsuario_0) {
        this.usuarioByIdUsuario_0 = usuarioByIdUsuario_0;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "IDPRODUCTO")
    public Producto getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(Producto productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "IDPRODUCTO")
    public Producto getProductoByIdProducto_0() {
        return productoByIdProducto_0;
    }

    public void setProductoByIdProducto_0(Producto productoByIdProducto_0) {
        this.productoByIdProducto_0 = productoByIdProducto_0;
    }
}
