package es.taw.proyecto.entity;

//import es.taw.proyecto.dto.ProductoDTO;

import es.taw.proyecto.dto.ProductoDTO;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Producto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPRODUCTO", nullable = false)
    private Integer idproducto;
    @Basic
    @Column(name = "TITULO", nullable = false, length = 45)
    private String titulo;
    @Basic
    @Column(name = "DESCRIPCION", nullable = false, length = 300)
    private String descripcion;
    @Basic
    @Column(name = "URL_IMAGEN", nullable = false, length = 500)
    private String urlImagen;
    @Basic
    @Column(name = "USUARIO_VENDEDOR", nullable = false)
    private Integer usuarioVendedor;
    @Basic
    @Column(name = "CATEGORIA_IDCATEGORIA", nullable = false)
    private Integer categoriaIdcategoria;
    @ManyToOne
    @JoinColumn(name = "USUARIO_VENDEDOR", referencedColumnName = "IDUSUARIO", nullable = false, insertable = false, updatable = false)
    private Usuario usuarioByUsuarioVendedor;
    @OneToMany(mappedBy = "productoIdproducto")
    private Collection<ProductosFavoritos> productosFavoritosByIdproducto;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        if (idproducto != null ? !idproducto.equals(producto.idproducto) : producto.idproducto != null) return false;
        if (titulo != null ? !titulo.equals(producto.titulo) : producto.titulo != null) return false;
        if (descripcion != null ? !descripcion.equals(producto.descripcion) : producto.descripcion != null)
            return false;
        if (urlImagen != null ? !urlImagen.equals(producto.urlImagen) : producto.urlImagen != null) return false;
        if (usuarioVendedor != null ? !usuarioVendedor.equals(producto.usuarioVendedor) : producto.usuarioVendedor != null)
            return false;
        if (categoriaIdcategoria != null ? !categoriaIdcategoria.equals(producto.categoriaIdcategoria) : producto.categoriaIdcategoria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproducto != null ? idproducto.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (urlImagen != null ? urlImagen.hashCode() : 0);
        result = 31 * result + (usuarioVendedor != null ? usuarioVendedor.hashCode() : 0);
        result = 31 * result + (categoriaIdcategoria != null ? categoriaIdcategoria.hashCode() : 0);
        return result;
    }

    public Usuario getUsuarioByUsuarioVendedor() {
        return usuarioByUsuarioVendedor;
    }

    public void setUsuarioByUsuarioVendedor(Usuario usuarioByUsuarioVendedor) {
        this.usuarioByUsuarioVendedor = usuarioByUsuarioVendedor;
    }

    public Collection<ProductosFavoritos> getProductosFavoritosByIdproducto() {
        return productosFavoritosByIdproducto;
    }

    public void setProductosFavoritosByIdproducto(Collection<ProductosFavoritos> productosFavoritosByIdproducto) {
        this.productosFavoritosByIdproducto = productosFavoritosByIdproducto;
    }

    public ProductoDTO toDTO() {
        ProductoDTO DTO = new ProductoDTO();

        DTO.setIdproducto(this.idproducto);
        DTO.setTitulo(this.titulo);
        DTO.setDescripcion(this.descripcion);
        DTO.setUrlImagen(this.urlImagen);
        DTO.setUsuarioVendedor(this.usuarioVendedor);
        DTO.setCategoriaIdcategoria(this.categoriaIdcategoria);
        DTO.setUsuarioByUsuarioVendedor(this.usuarioByUsuarioVendedor.toDTO());

        return DTO;
    }


    public void edit(ProductoDTO productoDTO) {
        this.setIdproducto(productoDTO.getIdproducto());
        this.setTitulo(productoDTO.getTitulo());
        this.setDescripcion(productoDTO.getDescripcion());
        this.setUrlImagen(productoDTO.getDescripcion());
        this.setUsuarioVendedor(productoDTO.getUsuarioVendedor());
        this.setCategoriaIdcategoria(productoDTO.getCategoriaIdcategoria());
    }
}
