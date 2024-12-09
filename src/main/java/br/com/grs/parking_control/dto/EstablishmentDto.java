package br.com.grs.parking_control.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class EstablishmentDto {

    @Data
    public static class Request {
        @NotBlank
        private String name;
        @NotBlank
        private String cnpj;
        @NotBlank
        private String address;
        @NotBlank
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
