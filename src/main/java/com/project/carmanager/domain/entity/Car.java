package com.project.carmanager.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.carmanager.domain.enums.CarType;
import com.project.carmanager.domain.enums.EngineType;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @JsonIgnore
    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "user_id")
    private User user;

}
