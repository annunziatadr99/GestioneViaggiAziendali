package com.demo.GestioneViaggiAziendali.repository;

import com.demo.GestioneViaggiAziendali.entities.Viaggio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
    @Override
    Page<Viaggio> findAll(Pageable pageable);
}
