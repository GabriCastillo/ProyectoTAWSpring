package es.taw.proyecto.dto;

import es.taw.proyecto.entity.Usuario;

public class UsuarioDTO {

    private Integer idusuario;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String ciudadResidencia;
    private int edad;
    private String sexo;
    private String password;
    private Integer rolIdrol;
    private RolDTO rol;

    public UsuarioDTO() {
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getRolIdrol() {
        return rolIdrol;
    }

    public void setRolIdrol(Integer rolIdrol) {
        this.rolIdrol = rolIdrol;
    }

    public Usuario toEntity() {
        Usuario entity = new Usuario();

        entity.setIdusuario(idusuario);
        entity.setRolIdrol(rolIdrol);
        entity.setNombre(nombre);
        entity.setPassword(password);
        entity.setApellido(apellido);
        entity.setCiudadResidencia(ciudadResidencia);
        entity.setDomicilio(domicilio);
        entity.setEdad(edad);
        entity.setSexo(sexo);

        return entity;
    }

}
