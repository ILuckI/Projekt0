package com.project0.ProjektGrupowy.service;

import com.project0.ProjektGrupowy.Entities.Car;
import com.project0.ProjektGrupowy.Entities.CarClass;
import com.project0.ProjektGrupowy.dto.CarClassDto;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.repository.CarClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CarClassService {

    @Autowired
    CarClassRepository carClassRepository;

    @Autowired
    ModelMapper modelMapper;

    public CarClassDto findCarClassById(Long carClassId) {
        CarClass carClassById = carClassRepository.findCarClassByCarClassId(carClassId);
        CarClassDto carClassByIdDto = new CarClassDto(carClassById.getCarClassName());
        return carClassByIdDto;
    }

    public List<CarClassDto> getAllCarClasses(){
        Iterable<CarClass> carClasses = carClassRepository.findAll();
        return StreamSupport.stream(carClasses.spliterator(), false)
                .map(carClass -> modelMapper.map(carClass, CarClassDto.class))
                .collect(Collectors.toList());
    }
}
