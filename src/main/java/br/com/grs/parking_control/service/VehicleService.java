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

    public List<VehicleDto.Response> getAll() {
        return this.vehicleRepository.findAllActive()
                .stream()
                .map(VehicleMapper::toDto)
                .toList();
    }

    public VehicleDto.Response create(VehicleDto.Request vehicleDto) {
        Vehicle vehicle = VehicleMapper.toEntity(vehicleDto);
        return VehicleMapper.toDto(this.vehicleRepository.save(vehicle));
    }

    public VehicleDto.Response update(Long vehicleId, VehicleDto.Request vehicleDto) {
        Vehicle existingVehicle = this.vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Do not exists any vehicle with this id."));

        VehicleMapper.updateEntityFromDto(vehicleDto, existingVehicle);

        return VehicleMapper.toDto(this.vehicleRepository.save(existingVehicle));
    }

    public VehicleDto.Response delete(Long vehicleId) {
        Vehicle vehicle = this.vehicleRepository
                .findById(vehicleId).orElseThrow(() -> new RuntimeException("Do not exists any vehicle with this id."));

        vehicle.setActive(false);

        return VehicleMapper.toDto(this.vehicleRepository.save(vehicle));
    }
}
