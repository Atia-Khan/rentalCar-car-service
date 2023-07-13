package com.atia.roadrunner.car.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atia.roadrunner.car.Model.Car;

@Repository
public interface ICarRepository extends JpaRepository<Car, Long> {
    
}
