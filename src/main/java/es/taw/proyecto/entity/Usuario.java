package es.taw.proyecto.entity;

import es.taw.proyecto.dto.UsuarioDTO;

import javax.persistence.*;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDUSUARIO", nullable = false)
    private Integer idusuario;
    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "APELLIDO", nullable = false, length = 45)
    private String apellido;
    @Basic
    @Column(name = "DOMICILIO", nullable = false, length = 45)
    private String domicilio;
    @Basic
    @Column(name = "CIUDAD_RESIDENCIA", nullable = false, length = 45)
    private String ciudadResidencia;
    @Basic
    @Column(name = "EDAD", nullable = false)
    private Integer edad;
    @Basic
    @Column(name = "SEXO", nullable = false, length = 45)
    private String sexo;
    @Basic
    @Column(name = "ROL_IDROL", nullable = false)
    private Integer rolIdrol;
    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Integer rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

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

        if (idusuario != null ? !idusuario.equals(usuario.idusuario) : usuario.idusuario != null) return false;
        if (nombre != null ? !nombre.equals(usuario.nombre) : usuario.nombre != null) return false;
        if (apellido != null ? !apellido.equals(usuario.apellido) : usuario.apellido != null) return false;
        if (domicilio != null ? !domicilio.equals(usuario.domicilio) : usuario.domicilio != null) return false;
        if (ciudadResidencia != null ? !ciudadResidencia.equals(usuario.ciudadResidencia) : usuario.ciudadResidencia != null)
            return false;
        if (edad != null ? !edad.equals(usuario.edad) : usuario.edad != null) return false;
        if (sexo != null ? !sexo.equals(usuario.sexo) : usuario.sexo != null) return false;
        if (rolIdrol != null ? !rolIdrol.equals(usuario.rolIdrol) : usuario.rolIdrol != null) return false;
        if (password != null ? !password.equals(usuario.password) : usuario.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idusuario != null ? idusuario.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (domicilio != null ? domicilio.hashCode() : 0);
        result = 31 * result + (ciudadResidencia != null ? ciudadResidencia.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        result = 31 * result + (rolIdrol != null ? rolIdrol.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public UsuarioDTO toDTO() {
        UsuarioDTO DTO = new UsuarioDTO();

        DTO.setIdusuario(idusuario);
        DTO.setRolIdrol(rolIdrol);
        DTO.setNombre(nombre);
        DTO.setPassword(password);
        DTO.setApellido(apellido);
        DTO.setCiudadResidencia(ciudadResidencia);
        DTO.setDomicilio(domicilio);
        DTO.setEdad(edad);
        DTO.setSexo(sexo);

        return DTO;
    }
}
