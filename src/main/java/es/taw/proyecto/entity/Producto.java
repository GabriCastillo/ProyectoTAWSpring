package es.taw.proyecto.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Producto {
    private Long id;
    private Integer idproducto;
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private Integer usuarioVendedor;
    private Integer categoriaIdcategoria;
    private List<CompradorProducto> compradorProductosByIdproducto;
    private List<Correo> correosByIdproducto;
    private List<Correo> correosByIdproducto_0;
    private Usuario usuarioByUsuarioVendedor;
    private Categoria categoriaByCategoriaIdcategoria;
    private List<ProductosFavoritos> productosFavoritosByIdproducto;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "IDPRODUCTO", nullable = false)
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    @Basic
    @Column(name = "TITULO", nullable = false, length = 45)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "DESCRIPCION", nullable = false, length = 300)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "URL_IMAGEN", nullable = false, length = 500)
    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Basic
    @Column(name = "USUARIO_VENDEDOR", nullable = false)
    public Integer getUsuarioVendedor() {
        return usuarioVendedor;
    }

    public void setUsuarioVendedor(Integer usuarioVendedor) {
        this.usuarioVendedor = usuarioVendedor;
    }

    @Basic
    @Column(name = "CATEGORIA_IDCATEGORIA", nullable = false)
    public Integer getCategoriaIdcategoria() {
        return categoriaIdcategoria;
    }

    public void setCategoriaIdcategoria(Integer categoriaIdcategoria) {
        this.categoriaIdcategoria = categoriaIdcategoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(idproducto, producto.idproducto) && Objects.equals(titulo, producto.titulo) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(urlImagen, producto.urlImagen) && Objects.equals(usuarioVendedor, producto.usuarioVendedor) && Objects.equals(categoriaIdcategoria, producto.categoriaIdcategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproducto, titulo, descripcion, urlImagen, usuarioVendedor, categoriaIdcategoria);
    }

    @OneToMany(mappedBy = "productoByProductoIdproducto")
    public List<CompradorProducto> getCompradorProductosByIdproducto() {
        return compradorProductosByIdproducto;
    }

    public void setCompradorProductosByIdproducto(List<CompradorProducto> compradorProductosByIdproducto) {
        this.compradorProductosByIdproducto = compradorProductosByIdproducto;
    }

    @OneToMany(mappedBy = "productoByIdProducto")
    public List<Correo> getCorreosByIdproducto() {
        return correosByIdproducto;
    }

    public void setCorreosByIdproducto(List<Correo> correosByIdproducto) {
        this.correosByIdproducto = correosByIdproducto;
    }

    @OneToMany(mappedBy = "productoByIdProducto_0")
    public List<Correo> getCorreosByIdproducto_0() {
        return correosByIdproducto_0;
    }

    public void setCorreosByIdproducto_0(List<Correo> correosByIdproducto_0) {
        this.correosByIdproducto_0 = correosByIdproducto_0;
    }

    @ManyToOne
    @JoinColumn(name = "USUARIO_VENDEDOR", referencedColumnName = "IDUSUARIO", nullable = false)
    public Usuario getUsuarioByUsuarioVendedor() {
        return usuarioByUsuarioVendedor;
    }

    public void setUsuarioByUsuarioVendedor(Usuario usuarioByUsuarioVendedor) {
        this.usuarioByUsuarioVendedor = usuarioByUsuarioVendedor;
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_IDCATEGORIA", referencedColumnName = "ID_CATEGORIA", nullable = false)
    public Categoria getCategoriaByCategoriaIdcategoria() {
        return categoriaByCategoriaIdcategoria;
    }

    public void setCategoriaByCategoriaIdcategoria(Categoria categoriaByCategoriaIdcategoria) {
        this.categoriaByCategoriaIdcategoria = categoriaByCategoriaIdcategoria;
    }

    @OneToMany(mappedBy = "productoByProductoIdproducto")
    public List<ProductosFavoritos> getProductosFavoritosByIdproducto() {
        return productosFavoritosByIdproducto;
    }

    public void setProductosFavoritosByIdproducto(List<ProductosFavoritos> productosFavoritosByIdproducto) {
        this.productosFavoritosByIdproducto = productosFavoritosByIdproducto;
    }
}
