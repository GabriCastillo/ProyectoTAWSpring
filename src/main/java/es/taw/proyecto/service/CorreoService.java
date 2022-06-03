package es.taw.proyecto.service;

import es.taw.proyecto.dao.CategoriaRepository;
import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.CorreoRepository;
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
}
