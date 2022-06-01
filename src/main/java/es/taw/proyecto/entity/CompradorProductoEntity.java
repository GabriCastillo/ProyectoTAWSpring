package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comprador_producto", schema = "proyectotaw", catalog = "")
public class CompradorProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDCOMPRA",nullable = false)
    private int idcompra;
    @Basic
    @Column(name = "PRECIO_SALIDA",nullable = false,length = 5)
    private int precioSalida;
    @Basic
    @Column(name = "PRECIO_COMPRA",nullable = false,length = 5)
    private int precioCompra;

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(int precioSalida) {
        this.precioSalida = precioSalida;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompradorProductoEntity that = (CompradorProductoEntity) o;
        return idcompra == that.idcompra && precioSalida == that.precioSalida && precioCompra == that.precioCompra;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcompra, precioSalida, precioCompra);
    }
}
