package br.com.grs.parking_control.repository;

import br.com.grs.parking_control.domain.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {

    @Query("SELECT e FROM Establishment e WHERE e.active = true")
    List<Establishment> findAllActive();
}
