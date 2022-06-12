package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    public List<Producto> findProductoByTituloAndAndCategoriaIdcategoria(String titulo,Integer categoria);
    public List<Producto> findProductoByTitulo(String titulo);
    public List<Producto> findProductoByCategoriaIdcategoria(Integer categoria);

    public Producto findProductoByTituloAndAndCategoriaIdcategoriaAndIdproducto(String titulo,Integer categoria,Integer id);
    public Producto findProductoByTituloAndIdproducto(String titulo,Integer id);
    public Producto findProductoByCategoriaIdcategoriaAndIdproducto(Integer categoria,Integer id);
}
