package com.project.carmanager.domain.dto;


import com.project.carmanager.domain.enums.EngineType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CarUpdateDTO {

    @NotNull
    private LocalDate nextService;

    @NotNull
    private int mileage;

    @NotNull
    private String oilType;

    @NotNull
    private EngineType engineType;

    @NotNull
    private int horsePower;
}
