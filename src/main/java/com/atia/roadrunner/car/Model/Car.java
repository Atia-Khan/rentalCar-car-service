package com.atia.roadrunner.car.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name="Cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String shortDesc;
    @Column(length = 1000)
    private String longDesc;
    private String imgLink;
    private double pricePerDay;

}
