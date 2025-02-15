package com.demo.GestioneViaggiAziendali.controllers;

import com.demo.GestioneViaggiAziendali.entities.Dipendente;
import com.demo.GestioneViaggiAziendali.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/dipendenti")
@Validated
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Dipendente> getAllDipendenti(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return dipendenteService.getDipendenti(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente getDipendenteById(@PathVariable Long id) {
        return dipendenteService.getDipendenteById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente createDipendente(@Valid @RequestBody Dipendente dipendente) {
        return dipendenteService.createDipendente(dipendente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente updateDipendente(@PathVariable Long id, @Valid @RequestBody Dipendente dettagliDipendente) {
        return dipendenteService.updateDipendente(id, dettagliDipendente).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteDipendente(id);
    }
}

