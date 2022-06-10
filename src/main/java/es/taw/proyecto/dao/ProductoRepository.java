package es.taw.proyecto.dao;

import es.taw.proyecto.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {


    List<Producto> findProductosByTitulo(String t);

    Producto findProductoByIdproducto(int i);
}