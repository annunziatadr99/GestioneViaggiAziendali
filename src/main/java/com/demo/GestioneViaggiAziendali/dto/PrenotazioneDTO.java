package com.demo.GestioneViaggiAziendali.dto;

import com.demo.GestioneViaggiAziendali.entities.Dipendente;
import com.demo.GestioneViaggiAziendali.entities.Viaggio;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;


@Data
public class PrenotazioneDTO {


    @NotNull(message = "Viaggio è obbligatoria")
    private Viaggio viaggio;


    @NotNull(message = "Dipendente è obbligatoria")
    private Dipendente dipendente;

    @NotNull(message = "Data di richiesta è obbligatoria")

    private LocalDate dataRichiesta;

    private String note;
}
