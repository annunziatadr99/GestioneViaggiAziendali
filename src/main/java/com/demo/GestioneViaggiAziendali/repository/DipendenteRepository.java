package com.demo.GestioneViaggiAziendali.repository;

import com.demo.GestioneViaggiAziendali.entities.Dipendente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente,Long> {
    @Override
    Page<Dipendente> findAll(Pageable pageable);
}
