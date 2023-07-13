package com.atia.roadrunner.car.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atia.roadrunner.car.Model.Car;
import com.atia.roadrunner.car.Repository.ICarRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private ICarRepository carRepo;
    
    @GetMapping(value="/getallcars")
public List<Car> getAllCars() {
    return carRepo.findAll();
}

@GetMapping("/get/{id}")
 public Car getCarById(@PathVariable Long id){
return carRepo.findById(id).orElse(null);
 }

@PostMapping("/post")
public Car postCar(@RequestBody Car cars){
    return carRepo.save(cars);
}

@PostMapping("/postall")
public List<Car> postHotel(@RequestBody List<Car> cars) {
    return carRepo.saveAll(cars);
}

}
