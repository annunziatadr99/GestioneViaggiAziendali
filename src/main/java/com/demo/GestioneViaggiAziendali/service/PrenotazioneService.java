package com.demo.GestioneViaggiAziendali.service;

import com.demo.GestioneViaggiAziendali.entities.Prenotazione;
import com.demo.GestioneViaggiAziendali.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public Page<Prenotazione> getPrenotazioni(Pageable pageable) {
        return prenotazioneRepository.findAll(pageable);
    }

    public Optional<Prenotazione> getPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id);
    }

    public Prenotazione createPrenotazione(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public Optional<Prenotazione> updatePrenotazione(Long id, Prenotazione dettagliPrenotazione) {
        return prenotazioneRepository.findById(id)
                .map(prenotazione -> {
                    prenotazione.setViaggio(dettagliPrenotazione.getViaggio());
                    prenotazione.setDipendente(dettagliPrenotazione.getDipendente());
                    prenotazione.setDataRichiesta(dettagliPrenotazione.getDataRichiesta());
                    prenotazione.setNote(dettagliPrenotazione.getNote());
                    return prenotazioneRepository.save(prenotazione);
                });
    }

    public void deletePrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }

    public List<Prenotazione> findByDipendenteAndData(Long dipendenteId, LocalDate dataRichiesta) {
        return prenotazioneRepository.findByDipendenteAndData(dipendenteId, dataRichiesta); //
    }
}

