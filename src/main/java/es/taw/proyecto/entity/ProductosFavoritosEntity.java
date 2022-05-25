package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "productos_favoritos", schema = "proyectotaw", catalog = "")
public class ProductosFavoritosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDFAVORITO",nullable = false)
    private int idfavorito;

    public int getIdfavorito() {
        return idfavorito;
    }

    public void setIdfavorito(int idfavorito) {
        this.idfavorito = idfavorito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosFavoritosEntity that = (ProductosFavoritosEntity) o;
        return idfavorito == that.idfavorito;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfavorito);
    }
}
