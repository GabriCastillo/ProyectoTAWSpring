package es.taw.proyecto.service;

import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.CategoriaDTO;
import es.taw.proyecto.dto.CompradorProductoDTO;
import es.taw.proyecto.dto.FavoritoDTO;
import es.taw.proyecto.entity.Categoria;
import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.ProductosFavoritos;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompradorProductoService {
    protected UsuarioRepository usuarioRepository;
    @Autowired
    public void  setUsuarioRepository(UsuarioRepository usuarioRepository){this.usuarioRepository=usuarioRepository;}
    protected CompradorProductoRepository compradorProductoRepository;
    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }
    public List<CompradorProductoDTO> toDTO (List<CompradorProducto> subastas) {
        List<CompradorProductoDTO> DTO = new ArrayList<>();
        for(CompradorProducto subasta : subastas) {
            DTO.add(subasta.toDTO());
        }
        return DTO;
    }
    public List<CompradorProductoDTO> findall(){
        return this.toDTO(this.compradorProductoRepository.findAll());
    }
    public void comprarSubasta(String strId,Integer comprador,String precio) {
        CompradorProducto subasta = this.compradorProductoRepository.getById(Integer.parseInt(strId));
        Usuario user = this.usuarioRepository.getById(comprador);
        subasta.setUsuarioComprador(user.getIdusuario());
        subasta.setUsuarioByUsuarioComprador(user);
        if(subasta.getPrecioCompra()!=Integer.parseInt(precio)){
            subasta.setPrecioSalida(Integer.parseInt(precio));



        }else{
            subasta.setPrecioCompra(0);
            subasta.setPrecioSalida(Integer.parseInt(precio));
        }

        this.compradorProductoRepository.save(subasta);
    }
    public CompradorProductoDTO find(String id){
        CompradorProducto DTO = this.compradorProductoRepository.findById(Integer.parseInt(id)).orElse(null);
        if(DTO==null){
            return null;
        }
        return DTO.toDTO();
    }

    public List<CompradorProductoDTO> filtro(String titulo, String categoria) {
        if (titulo.equals("") || titulo.isEmpty()) {
            if (categoria == null || categoria.isEmpty()) {
                return this.findall();
            } else {
                List<CompradorProducto> dto = this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_CategoriaIdcategoria(Integer.parseInt(categoria));
                return this.toDTO(dto);
            }
        } else {
            if (categoria == null || categoria.isEmpty()) {
                return this.toDTO(this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_Titulo(titulo));
            } else {
                return this.toDTO(this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_TituloAndProductoByProductoIdproducto_CategoriaIdcategoria(titulo, Integer.parseInt(categoria)));

            }

        }
    }
    public List<CompradorProductoDTO> filtroFavorito(String titulo, String categoria, List<FavoritoDTO> favoritos) {
        List<CompradorProducto> lista= new ArrayList<>();
        for(FavoritoDTO favorito: favoritos) {
            if (titulo.equals("") || titulo.isEmpty()) {
                if (categoria == null || categoria.isEmpty()) {
                    lista.add(this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_Idproducto(favorito.getProductoIdproducto()));
                } else {
                    CompradorProducto dto = this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_CategoriaIdcategoriaAndProductoByProductoIdproducto_Idproducto(Integer.parseInt(categoria),favorito.getProductoIdproducto());
                    if (dto!=null){
                      lista.add(dto);
                    }

                }
            } else {
                if (categoria == null || categoria.isEmpty()) {
                    CompradorProducto dto = this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_TituloAndProductoByProductoIdproducto_Idproducto(titulo, favorito.getProductoIdproducto());
                    if (dto!=null){
                        lista.add(dto);
                    }
                } else {
                    CompradorProducto dto = this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_TituloAndProductoByProductoIdproducto_CategoriaIdcategoriaAndProductoByProductoIdproducto_Idproducto(titulo, Integer.parseInt(categoria), favorito.getProductoIdproducto());
                    if (dto!=null){
                        lista.add(dto);
                    }

                }

            }
        }
        return this.toDTO(lista);
    }
    public List<CompradorProductoDTO> misfavoritos(List<FavoritoDTO> favoritos){
        List<CompradorProducto> lista= new ArrayList<CompradorProducto>();
        for (FavoritoDTO favorito:favoritos){
            lista.add(this.compradorProductoRepository.findCompradorProductoByProductoByProductoIdproducto_Idproducto(favorito.getProductoIdproducto()));
        }
        return this.toDTO(lista);
    }

    public List<CompradorProductoDTO> misproductos(Integer idusuario) {
        return this.toDTO(this.compradorProductoRepository.findCompradorProductoByUsuarioByUsuarioComprador_IdusuarioAndPrecioCompra(idusuario,0));
    }

    public List<CompradorProductoDTO> misproductosfiltro(String titulo, String categoria, List<CompradorProductoDTO> subastas) {
        List<CompradorProductoDTO> lista= new ArrayList<>();
        for(CompradorProductoDTO subasta: subastas) {
            if (titulo.equals("") || titulo.isEmpty()) {
                if (categoria == null || categoria.isEmpty()) {
                    lista.add(subasta);
                } else {
                    if(Integer.parseInt(categoria)==subasta.getProductoByProductoIdproducto().getCategoriaIdcategoria()){
                        lista.add(subasta);}


                }
            } else {
                if (categoria == null || categoria.isEmpty()) {
                    if (titulo.equalsIgnoreCase(subasta.getProductoByProductoIdproducto().getTitulo())){
                        lista.add(subasta);
                    }
                } else {
                    if (titulo.equalsIgnoreCase(subasta.getProductoByProductoIdproducto().getTitulo())&&Integer.parseInt(categoria)==subasta.getProductoByProductoIdproducto().getCategoriaIdcategoria()){
                        lista.add(subasta);
                    }

                }

            }
        }
        return lista;
    }
}

