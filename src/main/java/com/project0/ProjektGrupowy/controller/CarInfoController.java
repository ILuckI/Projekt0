package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CarInfoController {

    @Autowired
    CarService carService;

    @GetMapping("/carinfo")
    public ModelAndView findCar(@RequestParam("carName") String carName, Model model) {
        CarDto carByName = carService.findCarByName(carName);
        List<CarDto> allCars = carService.getAllCars();
        String carClassName = carService.findClassNameByCarName(carName);
        allCars.sort(Comparator.comparing(CarDto::getCarName));

        model.addAttribute("car", carByName);
        model.addAttribute("cars",allCars);
        model.addAttribute("carClassName",carClassName);

        return new ModelAndView("pages/carinformation", "model", model);
    }

}
