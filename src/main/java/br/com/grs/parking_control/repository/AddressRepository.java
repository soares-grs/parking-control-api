package br.com.grs.parking_control.repository;

import br.com.grs.parking_control.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStreetAndNumberAndCityAndStateAndPostalCodeAndCountry(
            String street, String number, String city, String state, String postalCode, String country);
}
