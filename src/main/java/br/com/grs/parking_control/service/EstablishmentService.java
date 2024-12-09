package br.com.grs.parking_control.service;

import br.com.grs.parking_control.domain.Establishment;
import br.com.grs.parking_control.dto.EstablishmentDto;
import br.com.grs.parking_control.repository.EstablishmentRepository;
import br.com.grs.parking_control.utils.EstablishmentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentFacade establishmentFacade;

    @Autowired
    private EstablishmentRepository establishmentRepo;

    public List<Establishment> getAll() {
        return this.establishmentRepo.findAll();
    }

    public Establishment create(EstablishmentDto.Request establishmentDto) {
        Establishment establishment = establishmentFacade.processEstablishmentCreation(establishmentDto);
        return this.establishmentRepo.save(establishment);
    }
}
