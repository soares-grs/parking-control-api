package br.com.grs.parking_control.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    private String number;
    private String complement;
    private String neighborhood;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false, length = 2)
    private String state;
    @Column(nullable = false, length = 10)
    private String postalCode;
    @Column(nullable = false)
    private String country;
}
