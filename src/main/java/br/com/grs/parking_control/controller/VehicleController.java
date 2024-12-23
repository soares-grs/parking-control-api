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
        return ResponseEntity.ok().body(this.vehicleService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody VehicleDto.Request vehicleDto) {
        VehicleDto.Response createdVehicle = this.vehicleService.create(vehicleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<?> update(@PathVariable Long vehicleId, @RequestBody VehicleDto.Request vehicleDto) {
        VehicleDto.Response updatedVehicle =  this.vehicleService.update(vehicleId, vehicleDto);

        return ResponseEntity.ok().body(updatedVehicle);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<?> delete(@PathVariable Long vehicleId) {
        return ResponseEntity.ok().body(this.vehicleService.delete(vehicleId));
    }
}
