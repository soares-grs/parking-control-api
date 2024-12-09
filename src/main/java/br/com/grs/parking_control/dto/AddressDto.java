package br.com.grs.parking_control.dto;

import lombok.Data;

public class AddressDto {
    @Data
    public static class Request {
        private String street;
        private String number;
        private String complement;
        private String neighborhood;
        private String city;
        private String state;
        private String postalCode;
        private String country;
    }
}
