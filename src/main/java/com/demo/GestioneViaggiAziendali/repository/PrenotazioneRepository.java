package com.demo.GestioneViaggiAziendali.repository;

import com.demo.GestioneViaggiAziendali.entities.Prenotazione;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {

    @Query("SELECT b FROM Booking b WHERE b.employee.id = :employeeId AND b.requestDate = :requestDate")
    List<Prenotazione> findByDipendenteAndData(@Param("dipendenteId") Long dipendenteId, @Param("dataRichiesta") LocalDate dataRichiesta);

   @Override
   Page<Prenotazione> findAll(Pageable pageable);
}

