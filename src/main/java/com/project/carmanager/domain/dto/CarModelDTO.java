package com.project.carmanager.dto;

import com.project.carmanager.enums.CarType;
import com.project.carmanager.enums.EngineType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CarModelDTO {

    @NotNull
    private Long id;

    @NotNull
    private String brand;

    @NotNull
    private String vinNumber;

    @NotNull
    private CarType carType;

    @NotNull
    private int yearOfProduction;

    @NotNull
    private LocalDate nextService;

    @NotNull
    private int mileage;

    @NotNull
    private String oilType;

    @NotNull
    private int amountOfDoors;

    @NotNull
    private EngineType engineType;

    @NotNull
    private int horsePower;
}
