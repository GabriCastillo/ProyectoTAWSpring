package es.taw.proyecto.entity;

import es.taw.proyecto.dto.CategoriaDTO;
import es.taw.proyecto.dto.CorreoDTO;

import javax.persistence.*;

@Entity
public class Correo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPROMO", nullable = false)
    private Integer idpromo;
    @Basic
    @Column(name = "MENSAJE", nullable = false, length = 300)
    private String mensaje;
    @Basic
    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;
    @Basic
    @Column(name = "ID_PRODUCTO", nullable = true)
    private Integer idProducto;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "IDUSUARIO", nullable = false, insertable = false, updatable = false)
    private Usuario usuarioByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "IDPRODUCTO", insertable = false, updatable = false)
    private Producto productoByIdProducto;

    public Integer getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

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

        if (idpromo != null ? !idpromo.equals(correo.idpromo) : correo.idpromo != null) return false;
        if (mensaje != null ? !mensaje.equals(correo.mensaje) : correo.mensaje != null) return false;
        if (idUsuario != null ? !idUsuario.equals(correo.idUsuario) : correo.idUsuario != null) return false;
        if (idProducto != null ? !idProducto.equals(correo.idProducto) : correo.idProducto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpromo != null ? idpromo.hashCode() : 0;
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        result = 31 * result + (idUsuario != null ? idUsuario.hashCode() : 0);
        result = 31 * result + (idProducto != null ? idProducto.hashCode() : 0);
        return result;
    }

    public Usuario getUsuarioByIdUsuario() {
        return usuarioByIdUsuario;
    }

    public void setUsuarioByIdUsuario(Usuario usuarioByIdUsuario) {
        this.usuarioByIdUsuario = usuarioByIdUsuario;
    }

    public Producto getProductoByIdProducto() {
        return productoByIdProducto;
    }

    public void setProductoByIdProducto(Producto productoByIdProducto) {
        this.productoByIdProducto = productoByIdProducto;
    }

    public CorreoDTO toDTO() {
        CorreoDTO DTO = new CorreoDTO();

        DTO.setIdpromo(this.idpromo);
        DTO.setMensaje(this.mensaje);
        DTO.setIdUsuario(this.idUsuario);
        DTO.setIdProducto(this.idProducto);
        DTO.setUsuarioByIdUsuario(this.usuarioByIdUsuario);
        DTO.setProductoByIdProducto(this.productoByIdProducto);

        return DTO;
    }
}
