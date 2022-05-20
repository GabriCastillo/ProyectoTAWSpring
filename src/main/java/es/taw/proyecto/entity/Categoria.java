package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria {
    private Long id;
    private Integer idCategoria;
    private String tipo;
    private List<Producto> productosByIdCategoria;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID_CATEGORIA", nullable = false)
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Basic
    @Column(name = "TIPO", nullable = false, length = 45)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(idCategoria, categoria.idCategoria) && Objects.equals(tipo, categoria.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria, tipo);
    }

    @OneToMany(mappedBy = "categoriaByCategoriaIdcategoria")
    public List<Producto> getProductosByIdCategoria() {
        return productosByIdCategoria;
    }

    public void setProductosByIdCategoria(List<Producto> productosByIdCategoria) {
        this.productosByIdCategoria = productosByIdCategoria;
    }
}
