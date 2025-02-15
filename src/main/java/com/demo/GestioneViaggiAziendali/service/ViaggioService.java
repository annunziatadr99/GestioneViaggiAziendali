package com.demo.GestioneViaggiAziendali.service;

import com.demo.GestioneViaggiAziendali.entities.Viaggio;
import com.demo.GestioneViaggiAziendali.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService {

   @Autowired
   private ViaggioRepository viaggioRepository;

   public List<Viaggio> getAllViaggio(){
       return viaggioRepository.findAll();
   }

    public Page<Viaggio> getViaggi(Pageable pageable) {
        return viaggioRepository.findAll(pageable);
    }

    public Optional<Viaggio> getViaggioById(Long id) {
        return viaggioRepository.findById(id);
    }

    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public Optional<Viaggio> updateViaggio(Long id, Viaggio dettagliViaggio) {
        return viaggioRepository.findById(id)
                .map(viaggio -> {
                    viaggio.setDestinazione(dettagliViaggio.getDestinazione());
                    viaggio.setDataPartenza(dettagliViaggio.getDataPartenza());
                    viaggio.setStato(dettagliViaggio.getStato());
                    return viaggioRepository.save(viaggio);
                });
    }

    public void deleteViaggio(Long id) {
        viaggioRepository.deleteById(id);
    }
}
