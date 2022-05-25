package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "producto", schema = "proyectotaw", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPRODUCTO",nullable = false)
    private int idproducto;
    @Basic
    @Column(name = "TITULO",nullable = false,length = 45)
    private String titulo;
    @Basic
    @Column(name = "DESCRIPCION",nullable = false,length = 300)
    private String descripcion;
    @Basic
    @Column(name = "URL_IMAGEN",nullable = false,length = 500)
    private String urlImagen;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return idproducto == that.idproducto && Objects.equals(titulo, that.titulo) && Objects.equals(descripcion, that.descripcion) && Objects.equals(urlImagen, that.urlImagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproducto, titulo, descripcion, urlImagen);
    }
}
