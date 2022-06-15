/*
    User: Javier
    Percentage: 50%
    Ruben 50%
 */

package es.taw.proyecto.dao;

import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompradorProductoRepository extends JpaRepository<CompradorProducto, Integer> {
    public List<CompradorProducto> findCompradorProductoByUsuarioByUsuarioCompradorIsNull();
    public List<CompradorProducto> findCompradorProductoByProductoByProductoIdproducto_TituloAndProductoByProductoIdproducto_CategoriaIdcategoria(String titulo,Integer categoria);
    public List<CompradorProducto> findCompradorProductoByProductoByProductoIdproducto_Titulo(String titulo);
    public List<CompradorProducto> findCompradorProductoByProductoByProductoIdproducto_CategoriaIdcategoria(Integer categoria);
    public CompradorProducto findCompradorProductoByProductoByProductoIdproducto_Idproducto(Integer id);

    public CompradorProducto findCompradorProductoByProductoByProductoIdproducto_TituloAndProductoByProductoIdproducto_CategoriaIdcategoriaAndProductoByProductoIdproducto_Idproducto(String titulo,Integer categoria,Integer id);
    public CompradorProducto findCompradorProductoByProductoByProductoIdproducto_TituloAndProductoByProductoIdproducto_Idproducto(String titulo,Integer id);
    public CompradorProducto findCompradorProductoByProductoByProductoIdproducto_CategoriaIdcategoriaAndProductoByProductoIdproducto_Idproducto(Integer categoria,Integer id);

    public List<CompradorProducto> findCompradorProductoByUsuarioByUsuarioComprador_IdusuarioAndPrecioCompra(Integer id,Integer precio);

    public List<CompradorProducto> findByUsuarioByUsuarioVendedor(Usuario usuarioByUsuarioVendedor);

    public CompradorProducto findByIdcompra(Integer idcompra);
}
