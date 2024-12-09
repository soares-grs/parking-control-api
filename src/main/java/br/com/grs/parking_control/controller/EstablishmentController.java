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
        List<Establishment> establishments = establishmentService.getAll();
        return ResponseEntity.ok().body(establishments);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody EstablishmentDto.Request establishmentDto) {
        Establishment createdEstablishment = establishmentService.create(establishmentDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstablishment);
    }

}
