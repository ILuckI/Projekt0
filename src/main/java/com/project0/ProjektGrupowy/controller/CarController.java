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

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/findcar")
    public ModelAndView findCar(@RequestParam("nameFragment") String nameFragment, Model model) {
        List<CarDto> byNameFragment = carService.findByNameFragment(nameFragment);
        return new ModelAndView("findcar", "cars", byNameFragment);
    }

    @RequestMapping("/find")
    public String findCar() {
        return "/pages/findcar";
    }

}

