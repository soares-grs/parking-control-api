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

    public static EstablishmentDto.Response toDto(Establishment establishment) {
        EstablishmentDto.Response establishmentDto = new EstablishmentDto.Response();
        establishmentDto.setId(establishment.getId());
        establishmentDto.setName(establishment.getName());
        establishmentDto.setAddress(establishment.getAddress());
        establishmentDto.setCnpj(establishment.getCnpj());
        establishmentDto.setPhone(establishment.getPhone());
        establishmentDto.setMotorcycleSlotCount(establishment.getMotorcycleSlotCount());
        establishmentDto.setCarSlotCount(establishment.getCarSlotCount());

        return establishmentDto;
    }

    public static void updateEntityFromDto(Establishment existingEstablishment, EstablishmentDto.Request establishmentDto, Address address) {
        MapperUtils.updateIfNotNull(establishmentDto.getName(), existingEstablishment::setName);
        MapperUtils.updateIfNotNull(address, existingEstablishment::setAddress);
        MapperUtils.updateIfNotNull(establishmentDto.getCnpj(), existingEstablishment::setCnpj);
        MapperUtils.updateIfNotNull(establishmentDto.getPhone(), existingEstablishment::setPhone);
        MapperUtils.updateIfNotNull(establishmentDto.getMotorcycleSlotCount(), existingEstablishment::setMotorcycleSlotCount);
        MapperUtils.updateIfNotNull(establishmentDto.getCarSlotCount(), existingEstablishment::setCarSlotCount);
    }
}
