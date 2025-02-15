package com.demo.GestioneViaggiAziendali.entities;

import com.demo.GestioneViaggiAziendali.enumerated.Stato;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "viaggi")
@Data
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La destinazione è obbligatoria")
    @Column(nullable = false)
    private String destinazione;

    @NotNull(message = "La data di partenza è obbligatoria")
    @FutureOrPresent(message = "La data deve essere presente o futura")
    @Column(nullable = false)
    private LocalDate dataPartenza;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Stato è obbligatoria")
    @Column(nullable = false)
    private Stato stato;
}
