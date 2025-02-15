package com.demo.GestioneViaggiAziendali.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "dipendenti")
@Data
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username è obbligatorio")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Nome è obbligatorio")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "Cognome è obbligatorio")
    @Column(nullable = false)
    private String cognome;

    @Email(message = "L'email deve essere valida")
    @NotBlank(message = "Email è obbligatorio")
    @Column(nullable = false, unique = true)
    private String email;

    private String profiloImageUrl;


}
