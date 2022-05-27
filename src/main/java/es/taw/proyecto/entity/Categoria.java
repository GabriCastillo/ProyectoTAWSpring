package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Categoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CATEGORIA", nullable = false)
    private Integer idCategoria;
    @Basic
    @Column(name = "TIPO", nullable = false, length = 45)
    private String tipo;
    @OneToMany(mappedBy = "categoriaIdcategoria")
    private Collection<Producto> productosByIdCategoria;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        if (idCategoria != null ? !idCategoria.equals(categoria.idCategoria) : categoria.idCategoria != null)
            return false;
        if (tipo != null ? !tipo.equals(categoria.tipo) : categoria.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategoria != null ? idCategoria.hashCode() : 0;
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    public Collection<Producto> getProductosByIdCategoria() {
        return productosByIdCategoria;
    }

    public void setProductosByIdCategoria(Collection<Producto> productosByIdCategoria) {
        this.productosByIdCategoria = productosByIdCategoria;
    }
}
