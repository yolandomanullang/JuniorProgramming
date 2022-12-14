package com.cobaspring.cobaspring.services;

import com.cobaspring.cobaspring.entities.CarEntity;
import com.cobaspring.cobaspring.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;


    @Override
    public CarEntity addCar(CarEntity param) {
        return   carRepository.save(param);
    }

    @Override
    public List<CarEntity> getAllCar() {
        return carRepository.findAll(Sort.sort(CarEntity.class));
    }

    @Override
    public CarEntity getById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param) {
        CarEntity findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setColor(param.getColor());
        findCar.setNumber(param.getNumber());
        findCar.setType(param.getType());


        return carRepository.save(param);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
