package br.com.grs.parking_control.dto;

import br.com.grs.parking_control.domain.VehicleType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class VehicleDto {
    @Data
    public static class Request {
        @NotBlank
        private String brand;
        @NotBlank
        private String model;
        @NotBlank
        private String color;
        @NotBlank
        private String plate;
        @NotBlank
        private VehicleType type;
    }
}
