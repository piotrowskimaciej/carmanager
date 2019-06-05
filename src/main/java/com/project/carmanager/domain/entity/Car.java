package com.project.carmanager.entity;

import com.project.carmanager.enums.CarType;
import com.project.carmanager.enums.EngineType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "vin_number")
    private String vinNumber;

    @Column(name = "car_type")
    @Enumerated(value = EnumType.STRING)
    private CarType carType;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @Column(name = "next_service")
    private LocalDate nextService;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "oil_type")
    private String oilType;

    @Column(name = "amount_of_doors")
    private int amountOfDoors;

    @Column(name = "engine_type")
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @Column(name = "horse_power")
    private int horsePower;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
