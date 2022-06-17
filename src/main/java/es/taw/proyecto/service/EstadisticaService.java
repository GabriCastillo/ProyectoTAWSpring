/*
    User: Jose
    Percentage: 100%
 */

package es.taw.proyecto.service;

import es.taw.proyecto.dao.CompradorProductoRepository;
import es.taw.proyecto.dao.EstadisticaRepository;
import es.taw.proyecto.dto.CompradorProductoDTO;
import es.taw.proyecto.dto.EstadisticaDTO;
import es.taw.proyecto.entity.Estadistica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadisticaService {

    protected EstadisticaRepository estadisticaRepository;

    public CompradorProductoRepository getCompradorProductoRepository() {
        return compradorProductoRepository;
    }

    @Autowired
    public void setCompradorProductoRepository(CompradorProductoRepository compradorProductoRepository) {
        this.compradorProductoRepository = compradorProductoRepository;
    }

    protected CompradorProductoRepository compradorProductoRepository;

    public CompradorProductoService getCompradorProductoService() {
        return compradorProductoService;
    }

    @Autowired
    public void setCompradorProductoService(CompradorProductoService compradorProductoService) {
        this.compradorProductoService = compradorProductoService;
    }

    protected CompradorProductoService compradorProductoService;

    @Autowired
    public void setEstadisticaRepository(EstadisticaRepository estadisticaRepository){this.estadisticaRepository=estadisticaRepository;}

    public void save(EstadisticaDTO estadisticaDTO) {
        Estadistica estadistica = new Estadistica();
        estadistica.edit(estadisticaDTO);
        estadistica.setValor(calcularValor(estadisticaDTO.getValorAnalisis()));
        this.estadisticaRepository.save(estadistica);
    }

    private Double calcularValor(Integer valorAnalisis) {
        double valor = 0;
        List<CompradorProductoDTO> productosVendidos = this.compradorProductoService.toDTO(this.compradorProductoRepository.findAll());
        switch (valorAnalisis){
            case 1:
                    int div = 0;
                    for(CompradorProductoDTO p: productosVendidos){
                        if (p.getPrecioCompra() == 0){
                            valor = valor + p.getPrecioSalida();
                            div++;
                        }

                    }
                    if (valor != 0){
                        valor = valor/div;
                    }

                    break;
            case 2:
                    int div2 = 0;
                     for(CompradorProductoDTO p: productosVendidos){
                         if (p.getPrecioCompra() != 0){
                             valor = valor + p.getPrecioSalida();
                             div2++;
                         }
                     }
                     valor = valor/div2;
                    break;

            case 3:
                    int cont = 0;
                    for (CompradorProductoDTO p: productosVendidos){
                        cont++;
                    }
                    valor = cont;
                    break;
        }
        return valor;
    }

    public void borrar(int parseInt) {
        Estadistica estadistica = this.estadisticaRepository.findEstadisticaByIdestadistica(parseInt);
        this.estadisticaRepository.delete(estadistica);
    }


    public List<EstadisticaDTO> listaEstadisticas(String titulo){
        List<Estadistica> estadisticas;
        Boolean ok = !((titulo == null) || (titulo.isEmpty()));
        if (!ok){
            estadisticas = this.estadisticaRepository.findAll();
        }else{
            estadisticas = this.estadisticaRepository.findBySimilarTitulo(titulo);
        }

        return this.toDTO(estadisticas);
    }

    public List<EstadisticaDTO> toDTO(List<Estadistica> lista){
        List<EstadisticaDTO> DTO = new ArrayList<>();
        for (Estadistica est:lista){
            DTO.add(est.toDTO());
        }
        return DTO;
    }

}

