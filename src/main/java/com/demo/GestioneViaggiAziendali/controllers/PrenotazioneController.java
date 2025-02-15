package com.demo.GestioneViaggiAziendali.controllers;

import com.demo.GestioneViaggiAziendali.entities.Prenotazione;
import com.demo.GestioneViaggiAziendali.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prenotazioni")
@Validated
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Prenotazione> getAllPrenotazioni(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return prenotazioneService.getPrenotazioni(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prenotazione getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.getPrenotazioneById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazione createPrenotazione(@Valid @RequestBody Prenotazione prenotazione) {
        return prenotazioneService.createPrenotazione(prenotazione);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Prenotazione updatePrenotazione(@PathVariable Long id, @Valid @RequestBody Prenotazione dettagliPrenotazione) {
        return prenotazioneService.updatePrenotazione(id, dettagliPrenotazione).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrenotazione(@PathVariable Long id) {
        prenotazioneService.deletePrenotazione(id);
    }
}

