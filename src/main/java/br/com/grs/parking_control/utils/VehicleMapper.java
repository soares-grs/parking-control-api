package br.com.grs.parking_control.utils;

import br.com.grs.parking_control.domain.Vehicle;
import br.com.grs.parking_control.dto.VehicleDto;

public class VehicleMapper {
    public static Vehicle toEntity(VehicleDto.Request vehicleDto) {
        Vehicle vehicle = new Vehicle();

        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setColor(vehicleDto.getColor());
        vehicle.setType(vehicleDto.getType());
        vehicle.setPlate(vehicleDto.getPlate());

        return vehicle;
    }
}
