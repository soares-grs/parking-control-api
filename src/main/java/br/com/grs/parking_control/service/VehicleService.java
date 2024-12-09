package br.com.grs.parking_control.service;

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
        return this.vehicleRepository.findAll();
    }

    public Vehicle create(VehicleDto.Request vehicleDto) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDto);
        return this.vehicleRepository.save(vehicle);
    }
}
