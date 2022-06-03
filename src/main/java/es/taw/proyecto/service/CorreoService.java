package es.taw.proyecto.service;

import es.taw.proyecto.dao.*;
import es.taw.proyecto.dto.CorreoDTO;
import es.taw.proyecto.entity.Correo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CorreoService {
    protected CompradorProductoRepository compradorProductoRepository;
    protected CategoriaRepository categoriaRepository;
    protected CorreoRepository correoRepository;
    protected UsuarioRepository usuarioRepository;
    protected ProductoRepository productoRepository;

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }

    @Autowired
    public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Autowired
    public void setCorreoRepository(CorreoRepository correoRepository) {
        this.correoRepository = correoRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    public void setProductoRepository(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<CorreoDTO> toDTO (List<Correo> correos) {
        List<CorreoDTO> DTO = new ArrayList<>();
        for(Correo correo : correos) {
            DTO.add(correo.toDTO());
        }
        return DTO;
    }

    public List<CorreoDTO> listarCorreos (Integer usuarioID) {
        List<Correo> correos = this.correoRepository.findCorreoByIdUsuario(usuarioID);

        if(!correos.isEmpty()) {
            return this.toDTO(correos);
        }

        return null;
    }

    public void crearCorreo (Integer usuarioID, String mensaje, Integer productoID) {
        Correo correo = new Correo();

        correo.setIdUsuario(usuarioID);
        correo.setUsuarioByIdUsuario(this.usuarioRepository.findById(usuarioID).orElse(null));

        correo.setMensaje(mensaje);

        if(productoID != 0) {
            correo.setIdProducto(productoID);
            correo.setProductoByIdProducto(this.productoRepository.findById(productoID).orElse(null));
        }

        this.correoRepository.save(correo);
    }

    public void borrarCorreo (Integer correoID) {
        this.correoRepository.deleteById(correoID);
    }

    public Integer obtenerUsuarioID(Integer correoID) {
        Correo correo = this.correoRepository.findById(correoID).orElse(null);
        return correo.getIdUsuario();
    }
}
