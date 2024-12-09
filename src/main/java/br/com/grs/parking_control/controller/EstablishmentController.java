package br.com.grs.parking_control.controller;

import br.com.grs.parking_control.domain.Establishment;
import br.com.grs.parking_control.dto.EstablishmentDto;
import br.com.grs.parking_control.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/establishment")
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<EstablishmentDto.Response> establishments = this.establishmentService.getAll();
        return ResponseEntity.ok().body(establishments);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EstablishmentDto.Request establishmentDto) {
        EstablishmentDto.Response createdEstablishment = this.establishmentService.create(establishmentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstablishment);
    }

    @PutMapping("/{establishmentId}")
    public ResponseEntity<?> update(@RequestBody EstablishmentDto.Request establishmentDto, @PathVariable Long establishmentId) {
        try {
            EstablishmentDto.Response updatedEstablishment = this.establishmentService.update(establishmentId, establishmentDto);
            return ResponseEntity.ok().body(updatedEstablishment);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{establishmentId}")
    public ResponseEntity<?> delete(@PathVariable Long establishmentId) {
        return ResponseEntity.ok().body(this.establishmentService.delete(establishmentId));
    }
}
