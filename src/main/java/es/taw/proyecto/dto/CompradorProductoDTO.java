package es.taw.proyecto.dto;

import es.taw.proyecto.entity.Producto;
import es.taw.proyecto.entity.Usuario;

public class CompradorProductoDTO {
    private Integer idcompra;
    private Integer precioSalida;
    private Integer precioCompra;
    private Integer usuarioComprador;
    private Integer usuarioVendedor;
    private Integer productoIdproducto;
    private Usuario usuarioByUsuarioComprador;
    private Usuario usuarioByUsuarioVendedor;
    private Producto productoByProductoIdproducto;

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public void setPrecioSalida(Integer precioSalida) {
        this.precioSalida = precioSalida;
    }

    public void setPrecioCompra(Integer precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setUsuarioComprador(Integer usuarioComprador) {
        this.usuarioComprador = usuarioComprador;
    }

    public void setUsuarioVendedor(Integer usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    public void setProductoIdproducto(Integer productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public void setUsuarioByUsuarioComprador(Usuario usuarioByUsuarioComprador) {
        this.usuarioByUsuarioComprador = usuarioByUsuarioComprador;
    }

    public void setUsuarioByUsuarioVendedor(Usuario usuarioByUsuarioVendedor) {
        this.usuarioByUsuarioVendedor = usuarioByUsuarioVendedor;
    }

    public void setProductoByProductoIdproducto(Producto productoByProductoIdproducto) {
        this.productoByProductoIdproducto = productoByProductoIdproducto;
    }

    public Integer getPrecioSalida() {
        return precioSalida;
    }

    public Integer getPrecioCompra() {
        return precioCompra;
    }

    public Integer getUsuarioComprador() {
        return usuarioComprador;
    }

    public Integer getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public Integer getProductoIdproducto() {
        return productoIdproducto;
    }

    public Usuario getUsuarioByUsuarioComprador() {
        return usuarioByUsuarioComprador;
    }

    public Usuario getUsuarioByUsuarioVendedor() {
        return usuarioByUsuarioVendedor;
    }

    public Producto getProductoByProductoIdproducto() {
        return productoByProductoIdproducto;
    }

    public Integer getIdcompra() {
        return idcompra;
    }
}
