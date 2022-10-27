package com.cobaspring.cobaspring.services;


import com.cobaspring.cobaspring.entities.CarEntity;
import com.cobaspring.cobaspring.entities.CarImage;
import com.cobaspring.cobaspring.wrappers.CarImageWrapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {

    CarEntity addCar(CarEntity param);

    List<CarEntity> getallCar();

    CarEntity getCarById(int id);

    CarEntity updateCar(CarEntity param);

    void deleteCar(int id);

    CarImage upload(CarImageWrapper carImageWrapper);
}
