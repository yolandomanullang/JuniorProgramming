package com.cobaspring.cobaspring.controllers;

import com.cobaspring.cobaspring.entities.CarEntity;
import com.cobaspring.cobaspring.repositories.CarRepository;
import com.cobaspring.cobaspring.response.CommonResponse;
import com.cobaspring.cobaspring.response.CommonResponseGenerator;
import com.cobaspring.cobaspring.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/car")
public class CarController {

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @Autowired
    CarService carService;

    @GetMapping(value = "checkApi")
    public CommonResponse<String> checkApi(){
        return commonResponseGenerator.successResponse("Hello kakak", "Sukses Api");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntity> addNewCar(@RequestBody CarEntity param){
        CarEntity car = carService.addCar(param);
        return commonResponseGenerator.successResponse(car,"Sukses Add New Car");
    }

    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntity>>getAllCar(){
        List<CarEntity> carList = carService.getAllCar();
        return commonResponseGenerator.successResponse(carList,"Sukses Get All Car")  ;
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntity> getById(@RequestParam int id){
        CarEntity car = carService.getById(id);
        return commonResponseGenerator.successResponse(car,"Sukses Get By Id");
    }

    @PostMapping(value = "updateCar")
    public CommonResponse<CarEntity> updateCar(@RequestBody CarEntity param){
        CarEntity car = carService.updateCar(param);
        return commonResponseGenerator.successResponse(car,"Sukses Update Car");
    }
    @DeleteMapping(value = "deleteCar")
    public CommonResponse<CarEntity> deleteCar(@RequestParam int id){
        carService.deleteCar(id);
        List<CarEntity> carList = carService.getAllCar();
        return commonResponseGenerator.successResponse(carList,"Sukses Delete Car");
    }
}