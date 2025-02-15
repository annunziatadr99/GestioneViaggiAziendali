package com.demo.GestioneViaggiAziendali.controllers;

import com.demo.GestioneViaggiAziendali.entities.Viaggio;
import com.demo.GestioneViaggiAziendali.enumerated.Stato;
import com.demo.GestioneViaggiAziendali.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/viaggi")
@Validated
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Viaggio> getAllViaggi(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return viaggioService.getViaggi(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio getViaggioById(@PathVariable Long id) {
        return viaggioService.getViaggioById(id).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggio createViaggio(@Valid @RequestBody Viaggio viaggio) {
        return viaggioService.createViaggio(viaggio);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio updateViaggio(@PathVariable Long id, @Valid @RequestBody Viaggio dettagliViaggio) {
        return viaggioService.updateViaggio(id, dettagliViaggio).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteViaggio(id);
    }

    @PatchMapping("/{id}/stato")
    @ResponseStatus(HttpStatus.OK)
    public Viaggio updateStatoViaggio(@PathVariable Long id, @RequestParam("stato") String stato) {
        Optional<Viaggio> viaggio = viaggioService.getViaggioById(id);
        if (viaggio.isPresent()) {
            Viaggio v = viaggio.get();
            v.setStato(Stato.valueOf(stato.toUpperCase()));
            return viaggioService.createViaggio(v);
        } else {
            return null;
        }
    }
}
