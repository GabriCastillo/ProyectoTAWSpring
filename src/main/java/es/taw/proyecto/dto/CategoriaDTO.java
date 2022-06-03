package es.taw.proyecto.dto;

import es.taw.proyecto.entity.Producto;

import javax.persistence.*;
import java.util.Collection;

public class CategoriaDTO {
    private Integer idCategoria;
    private String tipo;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
