package com.cobaspring.cobaspring.services;


import com.cobaspring.cobaspring.entities.CarEntity;
import com.cobaspring.cobaspring.entities.CarImage;
import com.cobaspring.cobaspring.repositories.CarImageRepository;
import com.cobaspring.cobaspring.repositories.CarRepository;
import com.cobaspring.cobaspring.wrappers.CarImageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarImageRepository carImageRepository;

    @Override
    public CarEntity addCar(CarEntity param) {

        return carRepository.save(param);
    }

    @Override
    public List<CarEntity> getallCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntity getCarById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntity updateCar(CarEntity param) {

        CarEntity findCar = carRepository.findById(param.getId()).get();
        findCar.setCarName(param.getCarName());
        findCar.setColor(param.getColor());
        findCar.setNumber(param.getNumber());
        findCar.setType(param.getType());

        return carRepository.save(findCar);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public CarImage upload(CarImageWrapper carImageWrapper) {

        CarImage carImage = new CarImage();
        carImage.setCar(carRepository.findById(carImageWrapper.getCarId()).get());
        carImage.setContentType(carImageWrapper.getContentType());
        carImage.setBase64(carImageWrapper.getBase64());
        return carImageRepository.save(carImage);
    }
}
