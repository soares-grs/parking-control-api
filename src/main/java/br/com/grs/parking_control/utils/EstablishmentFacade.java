package br.com.grs.parking_control.utils;

import br.com.grs.parking_control.domain.Address;
import br.com.grs.parking_control.domain.Establishment;
import br.com.grs.parking_control.dto.EstablishmentDto;
import br.com.grs.parking_control.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EstablishmentFacade {

    @Autowired
    private AddressService addressService;

    public void processAddressOnEstablishmentUpdate(EstablishmentDto.Request establishmentDto, Address currentAddress) {
        if(Objects.isNull(establishmentDto.getAddress())) return;

        AddressMapper.updateAddressFromDto(currentAddress, establishmentDto.getAddress());
    }

    private Address processAddressOnEstablishmentCreation(EstablishmentDto.Request establishmentDto) {
        Address address = addressService.findAddress(establishmentDto.getAddress());

        if (Objects.isNull(address)) {
            address = AddressMapper.toEntity(establishmentDto.getAddress());
            address = addressService.create(address);
        }

        return address;
    }

    public Establishment processEstablishmentCreation(EstablishmentDto.Request establishmentDto) {
        Address address = this.processAddressOnEstablishmentCreation(establishmentDto);
        return EstablishmentMapper.toEntity(establishmentDto, address);
    }
}
