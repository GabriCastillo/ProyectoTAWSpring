package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "proyectotaw")
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDUSUARIO", nullable = false)
    private int idusuario;
    @Basic
    @Column(name = "NOMBRE",nullable = false,length = 45)
    private String nombre;
    @Basic
    @Column(name = "APELLIDO",nullable = false,length = 45)
    private String apellido;
    @Basic
    @Column(name = "DOMICILIO",nullable = false,length = 45)
    private String domicilio;
    @Basic
    @Column(name = "CIUDAD_RESIDENCIA",nullable = false,length = 45)
    private String ciudadResidencia;
    @Basic
    @Column(name = "EDAD",nullable = false)
    private int edad;
    @Basic
    @Column(name = "SEXO",nullable = false,length = 45)
    private String sexo;
    @Basic
    @Column(name = "PASSWORD",nullable = false,length = 45)
    private String password;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
        UsuarioEntity that = (UsuarioEntity) o;
        return idusuario == that.idusuario && edad == that.edad && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(domicilio, that.domicilio) && Objects.equals(ciudadResidencia, that.ciudadResidencia) && Objects.equals(sexo, that.sexo) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusuario, nombre, apellido, domicilio, ciudadResidencia, edad, sexo, password);
    }
}
