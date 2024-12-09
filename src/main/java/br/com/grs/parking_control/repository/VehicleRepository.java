package br.com.grs.parking_control.repository;

import br.com.grs.parking_control.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
