package br.com.grs.parking_control.service;

import br.com.grs.parking_control.domain.Establishment;
import br.com.grs.parking_control.domain.Vehicle;
import br.com.grs.parking_control.dto.VehicleDto;
import br.com.grs.parking_control.repository.VehicleRepository;
import br.com.grs.parking_control.utils.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getAll() {
        return this.vehicleRepository.findAllActive();
    }

    public Vehicle create(VehicleDto.Request vehicleDto) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDto);
        return this.vehicleRepository.save(vehicle);
    }

    public Vehicle update(Long vehicleId, VehicleDto.Request vehicleDto) {
        Vehicle existingVehicle = this.vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Do not exists any vehicle with this id."));

        VehicleMapper.updateEntityFromDto(vehicleDto, existingVehicle);

        return this.vehicleRepository.save(existingVehicle);
    }

    public Vehicle delete(Long vehicleId) {
        Vehicle vehicle = this.vehicleRepository
                .findById(vehicleId).orElseThrow(() -> new RuntimeException("Do not exists any vehicle with this id."));

        vehicle.setActive(false);

        return this.vehicleRepository.save(vehicle);
    }
}
