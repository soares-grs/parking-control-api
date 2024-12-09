package br.com.grs.parking_control.utils;

import br.com.grs.parking_control.domain.Address;
import br.com.grs.parking_control.domain.Establishment;
import br.com.grs.parking_control.dto.EstablishmentDto;

public class EstablishmentMapper {
    public static Establishment toEntity(EstablishmentDto.Request establishmentDto, Address address) {
        Establishment establishment = new Establishment();
        establishment.setName(establishmentDto.getName());
        establishment.setAddress(address);
        establishment.setCnpj(establishmentDto.getCnpj());
        establishment.setPhone(establishmentDto.getPhone());
        establishment.setMotorcycleSlotCount(establishmentDto.getMotorcycleSlotCount());
        establishment.setCarSlotCount(establishmentDto.getCarSlotCount());

        return establishment;
    }
}
