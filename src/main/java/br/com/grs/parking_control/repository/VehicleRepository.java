package br.com.grs.parking_control.repository;

import br.com.grs.parking_control.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE v.active = true")
    List<Vehicle> findAllActive();
}
