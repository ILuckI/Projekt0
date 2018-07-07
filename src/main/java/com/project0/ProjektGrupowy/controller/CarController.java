package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.service.CarRentService;
import com.project0.ProjektGrupowy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Luck
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRentService carRentService;

    @GetMapping("/findcar")
    public ModelAndView findCar(@RequestParam("nameFragment") String nameFragment, Model model) {
        List<CarDto> byNameFragment = carService.findByNameFragment(nameFragment);
        return new ModelAndView("findcar", "cars", byNameFragment);
    }

    @PostMapping("/carInaccessible")
    public String search(@RequestParam("carName") String carName,
                               @RequestParam("date") String date,
                               @RequestParam("date1") String date1, Model model) {

//        String AAA = date.concat(" 00:00:00.00");
//        String BBB = date1.concat(" 00:00:00.00");
//
//        Timestamp dateT = Timestamp.valueOf(AAA);
//        Timestamp date2T = Timestamp.valueOf(BBB);
//
//        if (carRentService.isCarFree(carName, dateT, date2T)) {
//            return "/pages/carAvailable";
//        } else {
//            return "/pages/carInaccessible";
//        }
        return "/pages/carInaccessible";
    }

//    @RequestMapping("/find")
//    public String findCar() {
//        return "/pages/findcar";
//    }

}

