package br.com.grs.parking_control.repository;

import br.com.grs.parking_control.domain.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
}
