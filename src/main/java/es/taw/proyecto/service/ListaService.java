package es.taw.proyecto.service;

import es.taw.proyecto.dao.ListaRepository;
import es.taw.proyecto.dto.ListaDTO;
import es.taw.proyecto.entity.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaService {
    protected ListaRepository listaRepository;

    @Autowired
    public void setListaRepository(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    public List<ListaDTO> toDTO (List<Lista> listas) {
        List<ListaDTO> DTO = new ArrayList<>();
        for(Lista lista : listas) {
            DTO.add(lista.toDTO());
        }
        return DTO;
    }

    public List<ListaDTO> listarListas (String filtroListaAll) {
        List<Lista> listas;

        if((filtroListaAll == null) || filtroListaAll.equals("")) {
            listas = this.listaRepository.findAll();
        } else {
            listas = this.listaRepository.findListaByNombre(filtroListaAll);
        }

        if(listas != null) {
            return this.toDTO(listas);
        }

        return null;
    }

    public void crearLista (String nombreLista) {
        if((nombreLista != null) && !nombreLista.equals("")){
            Lista lista = new Lista();
            lista.setNombre(nombreLista);
            this.listaRepository.save(lista);
        }
    }

    public void borrarLista (String nombreListaBorrar) {
        this.listaRepository.deleteListaByNombre(nombreListaBorrar);
    }
}
