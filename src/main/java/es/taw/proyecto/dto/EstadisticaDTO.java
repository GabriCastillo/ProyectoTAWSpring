/*
    User: Jose
    Percentage: 100%
 */

package es.taw.proyecto.dto;

public class EstadisticaDTO {
    private Integer idEstadistica;
    private String nombre;
    private String descripcion;
    private Double valor;
    private Integer usuarioAnalista;
    private Integer valorAnalisis;

    public Integer getValorAnalisis() {return valorAnalisis;}

    public void setValorAnalisis(Integer valorAnalisis) {this.valorAnalisis = valorAnalisis;}


    public Integer getIdEstadistica() { return idEstadistica; }

    public void setIdEstadistica(Integer idEstadistica) { this.idEstadistica = idEstadistica; }

    public String getNombre() { return  nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getValor() { return valor; }

    public void setValor(Double valor) { this.valor = valor; }

    public Integer getUsuarioAnalista() {return usuarioAnalista; }

    public void setUsuarioAnalista(Integer usuarioAnalista) { this.usuarioAnalista = usuarioAnalista; }

}
