package br.com.grs.parking_control.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

public class EstablishmentDto {

    @Data
    public static class Request {
        @NotBlank
        private String name;
        @NotBlank
        @Pattern(regexp = "\\d{14}", message = "CNPJ must be 14 digits")
        private String cnpj;
        @NotBlank
        private AddressDto.Request address;
        @NotBlank
        @Pattern(regexp = "\\+\\d{2}\\s\\(\\d{2}\\)\\s\\d{5}-\\d{4}", message = "Phone must follow the format: +XX (XX) XXXXX-XXXX")
        private String phone;
        @NotBlank
        private Long motorcycleSlotCount;
        @NotBlank
        private Long carSlotCount;
    }

    @Data
    public static class Response {
        Long id;
        String name;
        String cnpj;
        String address;
        String phone;
        Long motorcycleSlotCount;
        Long carSlotCount;
    }
}
