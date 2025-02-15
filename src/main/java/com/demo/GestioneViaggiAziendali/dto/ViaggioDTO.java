package com.demo.GestioneViaggiAziendali.dto;

import com.demo.GestioneViaggiAziendali.enumerated.Stato;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioDTO {

    @NotBlank(message = "La destinazione è obbligatoria")
    private String destinazione;

    @NotNull(message = "La data di partenza è obbligatoria")
    @FutureOrPresent(message = "La data deve essere presente o futura")
    private LocalDate dataPartenza;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Stato è obbligatoria")
    private Stato stato;

}
