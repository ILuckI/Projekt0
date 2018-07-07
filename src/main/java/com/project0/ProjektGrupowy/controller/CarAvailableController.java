package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Luck
 */
@Controller
public class CarAvailableController {

    @Autowired
    private CarService carService;

    @RequestMapping("/carAvailable")
    public ModelAndView home() {
        List<CarDto> allCars = carService.getAllCars();
        allCars.sort(Comparator.comparing(CarDto::getCarName));
        return new ModelAndView("pages/carAvailable", "cars", allCars);
    }

}
