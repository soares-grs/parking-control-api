package br.com.grs.parking_control.service;

import br.com.grs.parking_control.domain.Address;
import br.com.grs.parking_control.domain.Establishment;
import br.com.grs.parking_control.dto.EstablishmentDto;
import br.com.grs.parking_control.repository.EstablishmentRepository;
import br.com.grs.parking_control.utils.EstablishmentFacade;
import br.com.grs.parking_control.utils.EstablishmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Establishment update(Long establishmentId, EstablishmentDto.Request establishmentDto) {
        Establishment existingEstablishment = this.establishmentRepo.findById(establishmentId)
                .orElseThrow(() -> new RuntimeException("Do not exists any establishment with this id."));

        establishmentFacade.processAddressOnEstablishmentUpdate(establishmentDto, existingEstablishment.getAddress());
        EstablishmentMapper.updateEntityFromDto(existingEstablishment, establishmentDto, existingEstablishment.getAddress());

        return this.establishmentRepo.save(existingEstablishment);
    }
}
