package br.com.grs.parking_control.utils;

import br.com.grs.parking_control.domain.Address;
import br.com.grs.parking_control.dto.AddressDto;

public class AddressMapper {
    public static Address toEntity(AddressDto.Request addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setComplement(addressDto.getComplement());
        address.setCountry(addressDto.getCountry());
        address.setNeighborhood(addressDto.getNeighborhood());
        address.setPostalCode(addressDto.getPostalCode());
        address.setNumber(addressDto.getNumber());
        address.setStreet(addressDto.getStreet());
        address.setState(addressDto.getState());
        return address;
    }

    public static void updateAddressFromDto(Address existingAddress, AddressDto.Request addressDto) {
        MapperUtils.updateIfNotNull(addressDto.getStreet(), existingAddress::setStreet);
        MapperUtils.updateIfNotNull(addressDto.getCity(), existingAddress::setCity);
        MapperUtils.updateIfNotNull(addressDto.getState(), existingAddress::setState);
        MapperUtils.updateIfNotNull(addressDto.getPostalCode(), existingAddress::setPostalCode);
        MapperUtils.updateIfNotNull(addressDto.getNeighborhood(), existingAddress::setNeighborhood);
        MapperUtils.updateIfNotNull(addressDto.getNumber(), existingAddress::setNumber);
        MapperUtils.updateIfNotNull(addressDto.getComplement(), existingAddress::setComplement);
        MapperUtils.updateIfNotNull(addressDto.getCountry(), existingAddress::setCountry);
    }
}
