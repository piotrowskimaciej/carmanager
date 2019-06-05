package com.project.carmanager.rest;

import com.project.carmanager.domain.dto.CarModelDTO;
import com.project.carmanager.domain.dto.CarUpdateDTO;
import com.project.carmanager.domain.entity.Car;
import com.project.carmanager.services.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_USER')")
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<Collection<Car>> getCars(){
        log.debug("getCars({})");
        return ResponseEntity.ok(carService.getCars());
    }

    @GetMapping("/{vin}")
    public ResponseEntity<Car> getCar(@PathVariable("vin") String vin) {
        log.debug("getCar({})", vin);
        return ResponseEntity.ok(carService.getCar(vin));
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody @Valid CarModelDTO carModelDTO) {
        log.debug("addCar({})", carModelDTO);
        return ResponseEntity.ok(carService.addCar(carModelDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody @Valid CarUpdateDTO carUpdateDTO) {
        log.debug("updateCar({})", id);
        return ResponseEntity.ok(carService.updateCar(id, carUpdateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable("id") Long id) {
        log.debug("deleteCar({})", id);
        return ResponseEntity.ok(carService.deleteCar(id));
    }


}
