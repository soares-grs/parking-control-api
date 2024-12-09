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

    public static VehicleDto.Response toDto(Vehicle vehicle) {
        VehicleDto.Response vehicleDto = new VehicleDto.Response();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setType(vehicle.getType());
        vehicleDto.setColor(vehicle.getColor());
        vehicleDto.setPlate(vehicle.getPlate());
        vehicleDto.setModel(vehicle.getModel());

        return vehicleDto;
    }

    public static void updateEntityFromDto(VehicleDto.Request vehicleDto, Vehicle existingVehicle) {
        MapperUtils.updateIfNotNull(vehicleDto.getBrand(), existingVehicle::setBrand);
        MapperUtils.updateIfNotNull(vehicleDto.getModel(), existingVehicle::setModel);
        MapperUtils.updateIfNotNull(vehicleDto.getColor(), existingVehicle::setColor);
        MapperUtils.updateIfNotNull(vehicleDto.getType(), existingVehicle::setType);
        MapperUtils.updateIfNotNull(vehicleDto.getPlate(), existingVehicle::setPlate);
    }
}
