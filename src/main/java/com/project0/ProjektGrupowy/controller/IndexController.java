package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Luck
 */
@Controller
public class IndexController {

    @Autowired
    private CarService carService;

    @RequestMapping("/")
    public ModelAndView home() {
        List<CarDto> allCars = carService.getAllCars();
        return new ModelAndView("index", "cars", allCars);
    }
}
