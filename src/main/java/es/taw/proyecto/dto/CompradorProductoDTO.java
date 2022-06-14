package es.taw.proyecto.dto;

import es.taw.proyecto.entity.Producto;
import es.taw.proyecto.entity.Usuario;

import javax.persistence.*;

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
}
