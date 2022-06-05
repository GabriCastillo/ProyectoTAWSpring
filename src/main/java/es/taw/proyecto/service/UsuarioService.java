package es.taw.proyecto.service;

import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.RolRepository;
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
    protected RolRepository rolRepository;

    public RolRepository getRolRepository() {
        return rolRepository;
    }

    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }

    public List<UsuarioDTO> toDTO(List<Usuario> usuarios) {
        List<UsuarioDTO> DTO = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            DTO.add(usuario.toDTO());
        }
        return DTO;
    }

    public UsuarioDTO comprobarCredenciales(String nombre, String password) {
        Usuario usuario = this.usuarioRepository.findUsuarioByNombreAndPassword(nombre, password);

        if (usuario != null) {
            return usuario.toDTO();
        }

        return null;
    }

    public List<UsuarioDTO> listarUsuarios(String nombre) {
        List<Usuario> usuarios;

        if ((nombre == null) || nombre.equals("")) {
            usuarios = this.usuarioRepository.findAll();
        } else {
            usuarios = this.usuarioRepository.findUsuarioByNombre(nombre);
        }

        if (usuarios != null) {
            return this.toDTO(usuarios);
        }

        return null;
    }

    public List<UsuarioDTO> listarUsuariosCompradores(List<UsuarioDTO> usuarios) {
        List<UsuarioDTO> compradores = new ArrayList<>();
        List<CompradorProducto> compradoresProductosAll = this.compradorProductoRepository.findAll();

        if ((usuarios != null) && !compradoresProductosAll.isEmpty()) {
            for (UsuarioDTO usuario : usuarios) {
                for (CompradorProducto compradorProducto : compradoresProductosAll) {
                    if ((compradorProducto.getUsuarioComprador() != null) && compradorProducto.getUsuarioComprador().equals(usuario.getIdusuario())) {
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

        if (usuario != null) {
            return usuario.getNombre() + " " + usuario.getApellido();
        }

        return null;
    }

    public List<UsuarioDTO> filtrarNombreApellidoRol(String filtroNombre, String filtroApellido, String filtroRol) {
        List<Usuario> usuarios;

        Boolean nombre = !((filtroNombre == null) || (filtroNombre.isEmpty()));
        Boolean apellido = !((filtroApellido == null) || (filtroApellido.isEmpty()));
        Boolean rol = !((filtroRol == null) || (filtroRol.isEmpty()));

        if (!nombre && !apellido && !rol) {

            usuarios = this.usuarioRepository.findAll();

        } else if (!nombre && !apellido && rol) {
            usuarios = this.usuarioRepository.findBySimilarRol(Integer.parseInt(filtroRol));

        } else if (!nombre && apellido && !rol) {
            usuarios = this.usuarioRepository.findBySimilarApellido(filtroApellido);

        } else if (!nombre && apellido && rol) {
            usuarios = this.usuarioRepository.findBySimilarApellidoAndRol(filtroApellido, Integer.parseInt(filtroRol));

        } else if (nombre && !apellido && !rol) {
            usuarios = this.usuarioRepository.findBySimilarNombre(filtroNombre);

        } else if (nombre && !apellido && rol) {
            usuarios = this.usuarioRepository.findBySimilarNombreAndRol(filtroNombre, Integer.parseInt(filtroRol));

        } else if (nombre && apellido && !rol) {
            usuarios = this.usuarioRepository.findBySimilarNombreAndApellido(filtroNombre, filtroApellido);

        } else {
            usuarios = this.usuarioRepository.findBySimilarNombreAndApellidoAndRol(filtroNombre, filtroApellido, Integer.parseInt(filtroRol));

        }

        return this.toDTO(usuarios);
    }


    public List<UsuarioDTO> asignarRolEntity(List<UsuarioDTO> usuarios) {
        List<UsuarioDTO> nuevousuarios = new ArrayList<>();

        for(UsuarioDTO u:usuarios){
            u.setRol(this.rolRepository.findByIdRol(u.getRolIdrol()).toDTO());
            nuevousuarios.add(u);
        }

        return nuevousuarios;

    }
}
