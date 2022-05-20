package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Estadistica {
    private Long id;
    private Integer idestadistica;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Integer usuarioAnalista;
    private Usuario usuarioByUsuarioAnalista;
    private List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdestadistica;
    private EstadisticaHasProductosFavoritos estadisticaHasProductosFavoritosByIdestadistica;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "IDESTADISTICA", nullable = false)
    public Integer getIdestadistica() {
        return idestadistica;
    }

    public void setIdestadistica(Integer idestadistica) {
        this.idestadistica = idestadistica;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = true, length = 255)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 255)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "VALOR", nullable = true, precision = 0)
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Basic
    @Column(name = "USUARIO_ANALISTA", nullable = false)
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
        return Objects.equals(idestadistica, that.idestadistica) && Objects.equals(nombre, that.nombre) && Objects.equals(descripcion, that.descripcion) && Objects.equals(valor, that.valor) && Objects.equals(usuarioAnalista, that.usuarioAnalista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idestadistica, nombre, descripcion, valor, usuarioAnalista);
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_ANALISTA", referencedColumnName = "IDUSUARIO", nullable = false)
    public Usuario getUsuarioByUsuarioAnalista() {
        return usuarioByUsuarioAnalista;
    }

    public void setUsuarioByUsuarioAnalista(Usuario usuarioByUsuarioAnalista) {
        this.usuarioByUsuarioAnalista = usuarioByUsuarioAnalista;
    }

    @OneToMany(mappedBy = "estadisticaByEstadisticaIdestadistica")
    public List<EstadisticaHasCompradorProducto> getEstadisticaHasCompradorProductosByIdestadistica() {
        return estadisticaHasCompradorProductosByIdestadistica;
    }

    public void setEstadisticaHasCompradorProductosByIdestadistica(List<EstadisticaHasCompradorProducto> estadisticaHasCompradorProductosByIdestadistica) {
        this.estadisticaHasCompradorProductosByIdestadistica = estadisticaHasCompradorProductosByIdestadistica;
    }

    @OneToOne(mappedBy = "estadisticaByEstadisticaIdestadistica")
    public EstadisticaHasProductosFavoritos getEstadisticaHasProductosFavoritosByIdestadistica() {
        return estadisticaHasProductosFavoritosByIdestadistica;
    }

    public void setEstadisticaHasProductosFavoritosByIdestadistica(EstadisticaHasProductosFavoritos estadisticaHasProductosFavoritosByIdestadistica) {
        this.estadisticaHasProductosFavoritosByIdestadistica = estadisticaHasProductosFavoritosByIdestadistica;
    }
}
