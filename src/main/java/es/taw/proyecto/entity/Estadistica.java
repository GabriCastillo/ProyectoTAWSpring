package es.taw.proyecto.entity;

import es.taw.proyecto.dto.EstadisticaDTO;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Estadistica {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDESTADISTICA", nullable = false)
    private Integer idestadistica;
    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 255)
    private String nombre;
    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "VALOR", nullable = true, precision = 0)
    private Double valor;
    @Basic
    @Column(name = "USUARIO_ANALISTA", nullable = false)
    private Integer usuarioAnalista;
    @ManyToOne
    @JoinColumn(name = "USUARIO_ANALISTA", referencedColumnName = "IDUSUARIO", nullable = false, insertable = false, updatable = false)
    private Usuario usuarioByUsuarioAnalista;
    @OneToMany(mappedBy = "estadisticaIdestadistica")
    private Collection<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdestadistica;

    public Integer getIdestadistica() {
        return idestadistica;
    }

    public void setIdestadistica(Integer idestadistica) {
        this.idestadistica = idestadistica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getUsuarioAnalista() {
        return usuarioAnalista;
    }

    public void setUsuarioAnalista(Integer usuarioAnalista) {
        this.usuarioAnalista = usuarioAnalista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadistica that = (Estadistica) o;

        if (idestadistica != null ? !idestadistica.equals(that.idestadistica) : that.idestadistica != null)
            return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (usuarioAnalista != null ? !usuarioAnalista.equals(that.usuarioAnalista) : that.usuarioAnalista != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idestadistica != null ? idestadistica.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (usuarioAnalista != null ? usuarioAnalista.hashCode() : 0);
        return result;
    }

    public Usuario getUsuarioByUsuarioAnalista() {
        return usuarioByUsuarioAnalista;
    }

    public void setUsuarioByUsuarioAnalista(Usuario usuarioByUsuarioAnalista) {
        this.usuarioByUsuarioAnalista = usuarioByUsuarioAnalista;
    }

    public Collection<EstadisticaHasCompradorProducto> getEstadisticaHasCompradorProductosByIdestadistica() {
        return estadisticaHasCompradorProductosByIdestadistica;
    }

    public void setEstadisticaHasCompradorProductosByIdestadistica(Collection<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdestadistica) {
        this.estadisticaHasCompradorProductosByIdestadistica = estadisticaHasCompradorProductosByIdestadistica;
    }

    public EstadisticaDTO toDTO(){
        EstadisticaDTO DTO = new EstadisticaDTO();

        DTO.setIdEstadistica(this.idestadistica);
        DTO.setNombre(this.nombre);
        DTO.setDescripcion(this.descripcion);
        DTO.setUsuarioAnalista(this.usuarioAnalista);
        DTO.setValor(this.valor);

        return DTO;
    }

    public void edit(EstadisticaDTO estadisticaDTO) {
        this.setIdestadistica(estadisticaDTO.getIdEstadistica());
        this.setNombre(estadisticaDTO.getNombre());
        this.setDescripcion(estadisticaDTO.getDescripcion());
        this.setUsuarioAnalista(estadisticaDTO.getUsuarioAnalista());
        this.setValor(estadisticaDTO.getValor());
    }
}
