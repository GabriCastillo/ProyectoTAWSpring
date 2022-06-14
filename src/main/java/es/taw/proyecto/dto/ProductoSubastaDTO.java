package es.taw.proyecto.dto;

public class ProductoSubastaDTO {
    private Integer precioCompra;
    private Integer precioSalida;

    private String descripcion;
    private String titulo;
    private String nombreCategoria;
    private String urlImagen;
    private Integer usuarioVendedor;

    public void setPrecioCompra(Integer precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioSalida(Integer precioSalida) {
        this.precioSalida = precioSalida;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setUsuarioVendedor(Integer usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    public Integer getPrecioCompra() {
        return precioCompra;
    }

    public Integer getPrecioSalida() {
        return precioSalida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Integer getUsuarioVendedor() {
        return usuarioVendedor;
    }
}
