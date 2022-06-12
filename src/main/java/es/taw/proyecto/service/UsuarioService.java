/*
    User: Javier
    Percentage: 100%
 */

package es.taw.proyecto.service;

import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.CompradorProducto;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    protected UsuarioRepository usuarioRepository;
    protected CompradorProductoRepository compradorProductoRepository;


    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }

    public List<UsuarioDTO> toDTO (List<Usuario> usuarios) {
        List<UsuarioDTO> DTO = new ArrayList<>();
        for(Usuario usuario : usuarios) {
            DTO.add(usuario.toDTO());
        }
        return DTO;
    }

    public UsuarioDTO comprobarCredenciales (String nombre, String password) {
        Usuario usuario = this.usuarioRepository.findUsuarioByNombreAndPassword(nombre, password);

        if (usuario != null) {
            return usuario.toDTO();
        }

        return null;
    }

    public List<UsuarioDTO> listarUsuarios (String nombre) {
        List<Usuario> usuarios;

        if((nombre == null) || nombre.equals("")) {
            usuarios = this.usuarioRepository.findAll();
        } else {
            usuarios = this.usuarioRepository.findUsuarioByNombre(nombre);
        }

        if(usuarios != null) {
            return this.toDTO(usuarios);
        }

        return null;
    }

    public Usuario idusuario(String id){
      return this.usuarioRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    public List<UsuarioDTO> listarUsuariosCompradores (List<UsuarioDTO> usuarios) {
        List<UsuarioDTO> compradores = new ArrayList<>();
        List<CompradorProducto> compradoresProductosAll = this.compradorProductoRepository.findAll();

        if((usuarios != null) && !compradoresProductosAll.isEmpty()) {
            for(UsuarioDTO usuario : usuarios) {
                for(CompradorProducto compradorProducto : compradoresProductosAll) {
                    if((compradorProducto.getUsuarioComprador() != null) && compradorProducto.getUsuarioComprador().equals(usuario.getIdusuario())) {
                        compradores.add(usuario);
                        break;
                    }
                }
            }
            return compradores;
        }

        return null;
    }

    public String obtenerNombreCompleto(Integer usuarioID) {
        Usuario usuario = this.usuarioRepository.findById(usuarioID).orElse(null);

        if(usuario != null) {
            return usuario.getNombre() + " " + usuario.getApellido();
        }

        return null;
    }
}
