package com.project0.ProjektGrupowy.service;

import com.project0.ProjektGrupowy.Entities.Car;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.repository.CarClassRepository;
import com.project0.ProjektGrupowy.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Luck
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CarClassRepository carClassRepository;

    public List<CarDto> findByNameFragment(String nameFragment) {
        List<Car> allByNameIsLike = carRepository.findAllByCarNameContaining(nameFragment);
        return allByNameIsLike.stream().map(entity -> modelMapper.map(entity, CarDto.class)).collect(Collectors.toList());
    }

    public List<CarDto> getAllCars() {
        Iterable<Car> cars = carRepository.findAll();
        return StreamSupport.stream(cars.spliterator(), false)
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    public long findCarIdByName(String carName) {
        long carIdByName = carRepository.findByCarName(carName).getCarId();
        return carIdByName;
    }

    public long findCarClassIdByCarName(String carName){
        long carClassIdByCarName = carRepository.findByCarName(carName).getCarClassId();
        return carClassIdByCarName;
    }

    public CarDto findCarByName(String carName){
       Car carByName = carRepository.findByCarName(carName);
       return modelMapper.map(carByName,CarDto.class);
    }

    public String findClassNameByCarName(String carName){
        long classId = carRepository.findByCarName(carName).getCarClassId();
        String carClassName = carClassRepository.findCarClassByCarClassId(classId).getCarClassName();
        return carClassName;
    }

}
