package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Lista {
    private Long id;
    private Integer idLista;
    private String nombre;
    private Integer usuarioLista;
    private Usuario usuarioByUsuarioLista;
    private Usuario usuarioByUsuarioLista_0;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID_LISTA", nullable = false)
    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "USUARIO_LISTA", nullable = true)
    public Integer getUsuarioLista() {
        return usuarioLista;
    }

    public void setUsuarioLista(Integer usuarioLista) {
        this.usuarioLista = usuarioLista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista lista = (Lista) o;
        return Objects.equals(idLista, lista.idLista) && Objects.equals(nombre, lista.nombre) && Objects.equals(usuarioLista, lista.usuarioLista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLista, nombre, usuarioLista);
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_LISTA", referencedColumnName = "IDUSUARIO")
    public Usuario getUsuarioByUsuarioLista() {
        return usuarioByUsuarioLista;
    }

    public void setUsuarioByUsuarioLista(Usuario usuarioByUsuarioLista) {
        this.usuarioByUsuarioLista = usuarioByUsuarioLista;
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_LISTA", referencedColumnName = "IDUSUARIO")
    public Usuario getUsuarioByUsuarioLista_0() {
        return usuarioByUsuarioLista_0;
    }

    public void setUsuarioByUsuarioLista_0(Usuario usuarioByUsuarioLista_0) {
        this.usuarioByUsuarioLista_0 = usuarioByUsuarioLista_0;
    }
}
