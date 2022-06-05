package es.taw.proyecto.service;

import es.taw.proyecto.dao.RolRepository;
import es.taw.proyecto.dto.RolDTO;
import es.taw.proyecto.dto.UsuarioDTO;
import es.taw.proyecto.entity.Rol;
import es.taw.proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Rolservice {
    protected RolRepository rolRepository;

    public RolRepository getRolRepository() {
        return rolRepository;
    }

    @Autowired
    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<RolDTO> toDTO(List<Rol> roles) {
        List<RolDTO> DTO = new ArrayList<>();
        for (Rol r : roles) {
            DTO.add(r.toDTO());
        }
        return DTO;
    }

    public List<RolDTO> findAll() {
        return toDTO(this.rolRepository.findAll());
    }
}
