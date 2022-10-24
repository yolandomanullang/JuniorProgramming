package com.cobaspring.cobaspring.services;

import com.cobaspring.cobaspring.entities.CarEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {

    CarEntity addCar(CarEntity param);


    List<CarEntity> getAllCar();

    CarEntity getById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);
}
