package es.taw.proyecto.dto;
/**
 NAME: Gabriel Castillo
 Done: 100%
 */
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
    public String toString(){
        return this.tipo;
    }
}
