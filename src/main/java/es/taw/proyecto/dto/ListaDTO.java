package es.taw.proyecto.dto;

import es.taw.proyecto.entity.Usuario;

import javax.persistence.*;

public class ListaDTO {
    private Integer idLista;
    private String nombre;
    private Integer usuarioLista;
    private Usuario usuarioByUsuarioLista;

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getUsuarioLista() {
        return usuarioLista;
    }

    public void setUsuarioLista(Integer usuarioLista) {
        this.usuarioLista = usuarioLista;
    }

    public Usuario getUsuarioByUsuarioLista() {
        return usuarioByUsuarioLista;
    }

    public void setUsuarioByUsuarioLista(Usuario usuarioByUsuarioLista) {
        this.usuarioByUsuarioLista = usuarioByUsuarioLista;
    }
}
