package es.taw.proyecto.entity;

import es.taw.proyecto.dto.ListaDTO;
import es.taw.proyecto.dto.UsuarioDTO;

import javax.persistence.*;

@Entity
public class Lista {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_LISTA", nullable = false)
    private Integer idLista;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "USUARIO_LISTA", nullable = true)
    private Integer usuarioLista;
    @ManyToOne
    @JoinColumn(name = "USUARIO_LISTA", referencedColumnName = "IDUSUARIO", insertable = false, updatable = false)
    private Usuario usuarioByUsuarioLista;

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

        if (idLista != null ? !idLista.equals(lista.idLista) : lista.idLista != null) return false;
        if (nombre != null ? !nombre.equals(lista.nombre) : lista.nombre != null) return false;
        if (usuarioLista != null ? !usuarioLista.equals(lista.usuarioLista) : lista.usuarioLista != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLista != null ? idLista.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (usuarioLista != null ? usuarioLista.hashCode() : 0);
        return result;
    }

    public Usuario getUsuarioByUsuarioLista() {
        return usuarioByUsuarioLista;
    }

    public void setUsuarioByUsuarioLista(Usuario usuarioByUsuarioLista) {
        this.usuarioByUsuarioLista = usuarioByUsuarioLista;
    }

    public ListaDTO toDTO() {
        ListaDTO DTO = new ListaDTO();

        DTO.setIdLista(this.idLista);
        DTO.setNombre(this.nombre);
        DTO.setUsuarioLista(this.usuarioLista);
        DTO.setUsuarioByUsuarioLista(this.usuarioByUsuarioLista);

        return DTO;
    }
}
