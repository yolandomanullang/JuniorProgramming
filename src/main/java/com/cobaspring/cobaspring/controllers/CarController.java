package com.cobaspring.cobaspring.controllers;

import com.cobaspring.cobaspring.entities.CarEntity;
import com.cobaspring.cobaspring.repositories.CarRepository;
import com.cobaspring.cobaspring.response.CommonResponse;
import com.cobaspring.cobaspring.response.CommonResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "checkApi")
    public CommonResponse<String> checkApi(){
        return commonResponseGenerator.successResponse("Hello kakak", "Sukses Api");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param){
        carRepository.save(param);
        return commonResponseGenerator.successResponse(param,"Sukses Add New Car");
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>>getAllCar(){
        return commonResponseGenerator.successResponse(carRepository.findAll(),"Sukses Get All Car")  ;
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id){
        return commonResponseGenerator.successResponse(carRepository.findById(id).get(),"Sukses Get By Id");
    }

    @PostMapping(value = "updateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param){
        return commonResponseGenerator.successResponse(carRepository.save(param),"Sukses Update Car");
    }
    @DeleteMapping(value = "deleteCar")
    public CommonResponse<CarEntity> deleteCar(@RequestParam int id){
        CarEntity car = carRepository.findById(id).get();
        carRepository.deleteById(id);
        return commonResponseGenerator.successResponse(car,"Sukses Delete Car");
    }
}