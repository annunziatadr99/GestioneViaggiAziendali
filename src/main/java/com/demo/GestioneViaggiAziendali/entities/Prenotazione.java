package com.demo.GestioneViaggiAziendali.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "viaggio_id", nullable = false)
    @NotNull(message = "Viaggio è obbligatoria")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "dipendente_id", nullable = false)
    @NotNull(message = "Dipendente è obbligatoria")
    private Dipendente dipendente;

    @NotNull(message = "Data di richiesta è obbligatoria")
    @Column(nullable = false)
    private LocalDate dataRichiesta;

    private String note;
}
