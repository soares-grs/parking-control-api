package br.com.grs.parking_control.service;

import br.com.grs.parking_control.domain.Address;
import br.com.grs.parking_control.dto.AddressDto;
import br.com.grs.parking_control.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address findAddress(AddressDto.Request addressDto) {
        return addressRepository.findByStreetAndNumberAndCityAndStateAndPostalCodeAndCountry(
                        addressDto.getStreet(),
                        addressDto.getNumber(),
                        addressDto.getCity(),
                        addressDto.getState(),
                        addressDto.getPostalCode(),
                        addressDto.getCountry())
                .orElse(null);
    }

    public Address create(Address address) {
        return this.addressRepository.save(address);
    }
}
