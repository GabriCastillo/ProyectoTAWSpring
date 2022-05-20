package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario {
    private Long id;
    private Integer idusuario;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String ciudadResidencia;
    private Integer edad;
    private String sexo;
    private Integer rolIdrol;
    private String password;
    private List<CompradorProducto> compradorProductosByIdusuario;
    private List<CompradorProducto> compradorProductosByIdusuario_0;
    private List<Correo> correosByIdusuario;
    private List<Correo> correosByIdusuario_0;
    private List<Estadistica> estadisticasByIdusuario;
    private List<Lista> listasByIdusuario;
    private List<Lista> listasByIdusuario_0;
    private List<Producto> productosByIdusuario;
    private List<ProductosFavoritos> productosFavoritosByIdusuario;
    private Rol rolByRolIdrol;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "IDUSUARIO", nullable = false)
    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
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
    @Column(name = "APELLIDO", nullable = false, length = 45)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "DOMICILIO", nullable = false, length = 45)
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    @Basic
    @Column(name = "CIUDAD_RESIDENCIA", nullable = false, length = 45)
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    @Basic
    @Column(name = "EDAD", nullable = false)
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "SEXO", nullable = false, length = 45)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "ROL_IDROL", nullable = false)
    public Integer getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Integer rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idusuario, usuario.idusuario) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(domicilio, usuario.domicilio) && Objects.equals(ciudadResidencia, usuario.ciudadResidencia) && Objects.equals(edad, usuario.edad) && Objects.equals(sexo, usuario.sexo) && Objects.equals(rolIdrol, usuario.rolIdrol) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusuario, nombre, apellido, domicilio, ciudadResidencia, edad, sexo, rolIdrol, password);
    }

    @OneToMany(mappedBy = "usuarioByUsuarioComprador")
    public List<CompradorProducto> getCompradorProductosByIdusuario() {
        return compradorProductosByIdusuario;
    }

    public void setCompradorProductosByIdusuario(List<CompradorProducto> compradorProductosByIdusuario) {
        this.compradorProductosByIdusuario = compradorProductosByIdusuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioVendedor")
    public List<CompradorProducto> getCompradorProductosByIdusuario_0() {
        return compradorProductosByIdusuario_0;
    }

    public void setCompradorProductosByIdusuario_0(List<CompradorProducto> compradorProductosByIdusuario_0) {
        this.compradorProductosByIdusuario_0 = compradorProductosByIdusuario_0;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario")
    public List<Correo> getCorreosByIdusuario() {
        return correosByIdusuario;
    }

    public void setCorreosByIdusuario(List<Correo> correosByIdusuario) {
        this.correosByIdusuario = correosByIdusuario;
    }

    @OneToMany(mappedBy = "usuarioByIdUsuario_0")
    public List<Correo> getCorreosByIdusuario_0() {
        return correosByIdusuario_0;
    }

    public void setCorreosByIdusuario_0(List<Correo> correosByIdusuario_0) {
        this.correosByIdusuario_0 = correosByIdusuario_0;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioAnalista")
    public List<Estadistica> getEstadisticasByIdusuario() {
        return estadisticasByIdusuario;
    }

    public void setEstadisticasByIdusuario(List<Estadistica> estadisticasByIdusuario) {
        this.estadisticasByIdusuario = estadisticasByIdusuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioLista")
    public List<Lista> getListasByIdusuario() {
        return listasByIdusuario;
    }

    public void setListasByIdusuario(List<Lista> listasByIdusuario) {
        this.listasByIdusuario = listasByIdusuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioLista_0")
    public List<Lista> getListasByIdusuario_0() {
        return listasByIdusuario_0;
    }

    public void setListasByIdusuario_0(List<Lista> listasByIdusuario_0) {
        this.listasByIdusuario_0 = listasByIdusuario_0;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioVendedor")
    public List<Producto> getProductosByIdusuario() {
        return productosByIdusuario;
    }

    public void setProductosByIdusuario(List<Producto> productosByIdusuario) {
        this.productosByIdusuario = productosByIdusuario;
    }

    @OneToMany(mappedBy = "usuarioByUsuarioComprador")
    public List<ProductosFavoritos> getProductosFavoritosByIdusuario() {
        return productosFavoritosByIdusuario;
    }

    public void setProductosFavoritosByIdusuario(List<ProductosFavoritos> productosFavoritosByIdusuario) {
        this.productosFavoritosByIdusuario = productosFavoritosByIdusuario;
    }

    @ManyToOne
    @JoinColumn(name = "ROL_IDROL", referencedColumnName = "ID_ROL", nullable = false)
    public Rol getRolByRolIdrol() {
        return rolByRolIdrol;
    }

    public void setRolByRolIdrol(Rol rolByRolIdrol) {
        this.rolByRolIdrol = rolByRolIdrol;
    }
}
