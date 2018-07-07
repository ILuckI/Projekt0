package com.project0.ProjektGrupowy.service;

import com.project0.ProjektGrupowy.Entities.CarRent;
import com.project0.ProjektGrupowy.repository.CarRentRepository;
import com.project0.ProjektGrupowy.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CarRentService {

    @Autowired
    CarRentRepository carRentRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    ModelMapper modelMapper;

    public boolean isCarFree(String carName, Timestamp rentDate, Timestamp returnDate) {

        Long carId = carRepository.findByCarName(carName).getCarId();
        List<CarRent> carsById = carRentRepository.findAllByCarId(carId);

        for (int i = 0; i < carsById.size(); i++) {
            Timestamp startDB = carsById.get(i).getRentDate();
            Timestamp endDB = carsById.get(i).getReturnDate();

            if ((startDB.after(rentDate) && endDB.after(returnDate) && startDB.after(returnDate))
                    || (rentDate.after(startDB) && returnDate.after(endDB) && rentDate.after(endDB))) {
            } else {
                return false;
            }
        }
        return true;
    }
}
