package com.demo.GestioneViaggiAziendali.service;

import com.demo.GestioneViaggiAziendali.entities.Dipendente;
import com.demo.GestioneViaggiAziendali.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

   @Autowired
   private DipendenteRepository dipendenteRepository;

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }

    public Page<Dipendente> getDipendenti(Pageable pageable) {
        return dipendenteRepository.findAll(pageable);
    }

    public Optional<Dipendente> getDipendenteById(Long id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente createDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Optional<Dipendente> updateDipendente(Long id, Dipendente dettagliDipendente) {
        return dipendenteRepository.findById(id)
                .map(dipendente -> {
                    dipendente.setUsername(dettagliDipendente.getUsername());
                    dipendente.setNome(dettagliDipendente.getNome());
                    dipendente.setCognome(dettagliDipendente.getCognome());
                    dipendente.setEmail(dettagliDipendente.getEmail());
                    dipendente.setProfiloImageUrl(dettagliDipendente.getProfiloImageUrl());
                    return dipendenteRepository.save(dipendente);
                });
    }

    public void deleteDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }
}
