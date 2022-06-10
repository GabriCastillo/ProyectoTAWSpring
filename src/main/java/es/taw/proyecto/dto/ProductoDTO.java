package es.taw.proyecto.dto;

import es.taw.proyecto.entity.Usuario;

public class ProductoDTO {
    private Integer idproducto;
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private Integer usuarioVendedor;
    private Integer categoriaIdcategoria;
    private Usuario usuarioByUsuarioVendedor;
    private CategoriaDTO categoriaDTO;

    public CategoriaDTO getCategoriaDTO() {
        return categoriaDTO;
    }

    public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
        this.categoriaDTO = categoriaDTO;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Integer usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    public Integer getCategoriaIdcategoria() {
        return categoriaIdcategoria;
    }

    public void setCategoriaIdcategoria(Integer categoriaIdcategoria) {
        this.categoriaIdcategoria = categoriaIdcategoria;
    }

    public Usuario getUsuarioByUsuarioVendedor() {
        return usuarioByUsuarioVendedor;
    }

    public void setUsuarioByUsuarioVendedor(Usuario usuarioByUsuarioVendedor) {
        this.usuarioByUsuarioVendedor = usuarioByUsuarioVendedor;
    }
}
