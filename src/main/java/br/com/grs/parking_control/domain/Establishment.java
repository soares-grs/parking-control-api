package br.com.grs.parking_control.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String cnpj;
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
    private String phone;
    private Long motorcycleSlotCount;
    private Long carSlotCount;
}
