package com.project.carmanager.repository;

import com.project.carmanager.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    boolean existsByVinNumber(String vinNumber);
    Collection<Car> findByUser_Id(Long userId);
    Optional<Car> findById(Long id);
    Optional<Car> findByVinNumberAndUser_Id(String vinNumber, Long userId);
}
