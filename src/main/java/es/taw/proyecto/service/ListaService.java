/*
    User: Javier
    Percentage: 100%
 */

package es.taw.proyecto.service;

import es.taw.proyecto.dao.ListaRepository;
import es.taw.proyecto.dao.UsuarioRepository;
import es.taw.proyecto.dto.ListaDTO;
import es.taw.proyecto.entity.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaService {
    protected ListaRepository listaRepository;
    protected UsuarioRepository usuarioRepository;

    @Autowired
    public void setListaRepository(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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

    public void borrarListas (String nombreListaBorrar) {
        this.listaRepository.deleteListaByNombre(nombreListaBorrar);
    }

    public void borrarLista (Integer listaID) {
        Lista lista = this.listaRepository.findById(listaID).orElse(null);
        List<Lista> listas = this.listaRepository.findListaByNombre(lista.getNombre());

        if(listas.size() != 1) {
            this.listaRepository.deleteById(listaID);
        } else {
            lista.setUsuarioLista(null);
            lista.setUsuarioByUsuarioLista(null);
            this.listaRepository.save(lista);
        }
    }

    public void crearListaUsuario(Integer listaID, Integer usuarioID) {
        Lista lista = this.listaRepository.findById(listaID).orElse(null);

        if(lista.getUsuarioByUsuarioLista() == null) {
            lista.setUsuarioLista(usuarioID);
            lista.setUsuarioByUsuarioLista(this.usuarioRepository.findById(usuarioID).orElse(null));
            this.listaRepository.save(lista);
        } else {
            List<Lista> listaUsuarios = this.listaRepository.findListaByNombre(lista.getNombre());
            Boolean usuarioExiste = false;
            for(Lista listaUsuario : listaUsuarios) {
                if(listaUsuario.getUsuarioLista().equals(usuarioID)) {
                    usuarioExiste = true;
                }
            }

            if(!usuarioExiste) {
                Lista listaNew = new Lista();
                listaNew.setNombre(lista.getNombre());
                listaNew.setUsuarioLista(usuarioID);
                listaNew.setUsuarioByUsuarioLista(this.usuarioRepository.findById(usuarioID).orElse(null));
                this.listaRepository.save(listaNew);
            }
        }
    }

    public String obtenerNombre(Integer listaID) {
        Lista lista = this.listaRepository.findById(listaID).orElse(null);
        return lista.getNombre();
    }
}
