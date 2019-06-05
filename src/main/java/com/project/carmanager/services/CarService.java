package com.project.carmanager.services;

import com.project.carmanager.domain.dto.CarModelDTO;
import com.project.carmanager.domain.dto.CarUpdateDTO;
import com.project.carmanager.domain.entity.Car;
import com.project.carmanager.domain.entity.User;
import com.project.carmanager.exceptions.ObjectAlreadyExistException;
import com.project.carmanager.exceptions.ObjectNotFoundException;
import com.project.carmanager.repository.CarRepository;
import com.project.carmanager.repository.UserRepository;
import com.project.carmanager.config.security.utils.GetUserData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Slf4j
@Service
public class CarService {

    private CarRepository carRepository;
    private UserRepository userRepository;


    public CarService(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Car addCar(CarModelDTO carModelDTO) {
        log.debug("addCar({})", carModelDTO);
        isCarExist(carModelDTO);
        User actualUser = getActualUser();
        return carRepository.save(prepareCar(carModelDTO, actualUser));
    }

    @Transactional(readOnly = true)
    public Collection<Car> getCars() {
        log.debug("getCars()");
        User actualUser = getActualUser();
        return carRepository.findByUser_Id(actualUser.getId());
    }

    @Transactional(readOnly = true)
    public Car getCar(String vin) {
        log.debug("getCar({})", vin);
        User actualUser = getActualUser();
        return carRepository.findByVinNumberAndUser_Id(vin, actualUser.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Car not found!"));
    }

    @Transactional
    public Car updateCar(Long id, CarUpdateDTO carUpdateDTO) {
        log.debug("updateCar({} {})", id, carUpdateDTO);
        Car car = findCarById(id);
        return carRepository.save(prepareUpdate(car, carUpdateDTO));

    }

    @Transactional
    public Car deleteCar(Long id) {
        log.debug("deleteCar({})", id);
        Car car = findCarById(id);
        carRepository.delete(car);
        return car;
    }

    private Car findCarById(Long id) {
        return carRepository.findById(id)
                    .orElseThrow(() -> new ObjectNotFoundException("Car not found!"));
    }

    private User getActualUser() {
        return userRepository.findByUsername(GetUserData.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }

    private void isCarExist(CarModelDTO carModelDTO) {
        if (carRepository.existsByVinNumber(carModelDTO.getVinNumber())) {
            throw new ObjectAlreadyExistException("This car actually exists in database!");
        }
    }

    private Car prepareCar(CarModelDTO dto, User actualUser) {
        return Car.builder()
                .brand(dto.getBrand())
                .vinNumber(dto.getVinNumber())
                .carType(dto.getCarType())
                .yearOfProduction(dto.getYearOfProduction())
                .nextService(dto.getNextService())
                .mileage(dto.getMileage())
                .oilType(dto.getOilType())
                .amountOfDoors(dto.getAmountOfDoors())
                .engineType(dto.getEngineType())
                .horsePower(dto.getHorsePower())
                .user(actualUser)
                .build();
    }

    private Car prepareUpdate(Car car, CarUpdateDTO dto) {
        car.setNextService(dto.getNextService());
        car.setMileage(dto.getMileage());
        car.setOilType(dto.getOilType());
        car.setEngineType(dto.getEngineType());
        car.setHorsePower(dto.getHorsePower());

        return car;
    }
}
