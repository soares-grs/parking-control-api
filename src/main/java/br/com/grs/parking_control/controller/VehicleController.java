package br.com.grs.parking_control.controller;

import br.com.grs.parking_control.domain.Vehicle;
import br.com.grs.parking_control.dto.VehicleDto;
import br.com.grs.parking_control.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(vehicleService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VehicleDto.Request vehicleDto) {
        Vehicle createdVehicle = vehicleService.create(vehicleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }
}
