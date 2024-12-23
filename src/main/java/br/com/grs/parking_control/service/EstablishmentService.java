package br.com.grs.parking_control.service;

import br.com.grs.parking_control.domain.Establishment;
import br.com.grs.parking_control.dto.EstablishmentDto;
import br.com.grs.parking_control.repository.EstablishmentRepository;
import br.com.grs.parking_control.utils.EstablishmentFacade;
import br.com.grs.parking_control.utils.EstablishmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentFacade establishmentFacade;

    @Autowired
    private EstablishmentRepository establishmentRepo;

    public List<EstablishmentDto.Response> getAll() {
        return this.establishmentRepo.findAllActive()
                .stream()
                .map(EstablishmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public EstablishmentDto.Response create(EstablishmentDto.Request establishmentDto) {
        Establishment establishment = establishmentFacade.processEstablishmentCreation(establishmentDto);
        return EstablishmentMapper.toDto(this.establishmentRepo.save(establishment));
    }

    public EstablishmentDto.Response update(Long establishmentId, EstablishmentDto.Request establishmentDto) {
        Establishment existingEstablishment = this.establishmentRepo.findById(establishmentId)
                .orElseThrow(() -> new RuntimeException("Do not exists any establishment with this id."));

        establishmentFacade.processAddressOnEstablishmentUpdate(establishmentDto, existingEstablishment.getAddress());
        EstablishmentMapper.updateEntityFromDto(existingEstablishment, establishmentDto, existingEstablishment.getAddress());

        return EstablishmentMapper.toDto(this.establishmentRepo.save(existingEstablishment));
    }

    public EstablishmentDto.Response delete(Long establishmentId) {
        Establishment establishment = this.establishmentRepo
                .findById(establishmentId).orElseThrow(() -> new RuntimeException("Do not exists any establishment with this id."));

        establishment.setActive(false);

        return EstablishmentMapper.toDto(this.establishmentRepo.save(establishment));
    }
}
