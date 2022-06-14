package es.taw.proyecto.dto;

import javax.persistence.*;

public class FavoritoDTO {

    private Integer idfavorito;

    private Integer usuarioComprador;

    private Integer productoIdproducto;

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
}
