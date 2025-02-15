package com.demo.GestioneViaggiAziendali.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DipendenteDTO {

    @NotBlank(message = "Username è obbligatorio")
    private String username;

    @NotBlank(message = "Nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Cognome è obbligatorio")
    private String cognome;

    @Email(message = "L'email deve essere valida")
    @NotBlank(message = "Email è obbligatorio")
    private String email;
}
