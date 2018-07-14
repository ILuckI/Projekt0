package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.service.CarRentService;
import com.project0.ProjektGrupowy.service.CarService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

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
//        Metoda przyjmuje trzy parametry
    @PostMapping("/searchCar")
    public ModelAndView search(@RequestParam("carName") String carName,
                               @RequestParam("date") String dateStart,
                               @RequestParam("date1") String dateEnd, Model model) {

//        Na podstawie uzyskanych parametrów tworzy obiekty Timestamp
        String startString = dateStart.concat(" 00:00:00.00");
        String endString = dateEnd.concat(" 00:00:00.00");

        Timestamp dateStartTimestamp = Timestamp.valueOf(startString);
        Timestamp dateEndTimestamnp = Timestamp.valueOf(endString);

//        Lista wszystkich dostępnych samochodów przekazywana póżniej do dropdownów w wyszukiwarce
        List<CarDto> allCars = carService.getAllCars();
        allCars.sort(Comparator.comparing(CarDto::getCarName));

//        Przekazanie atrybutow do modelu
        Map<String, Object> modelMap = new HashMap<String, Object>();
        model.addAttribute("dateStart", dateStart);
        model.addAttribute("dateEnd", dateEnd);
        model.addAttribute("carName", carName);

//        Sprawdzenie dostępności wybranego samochodu, przekierowanie do odpowieniego widoku wraz z atrybutami
        if (carRentService.isCarFree(carName, dateStartTimestamp, dateEndTimestamnp)
                && (dateEndTimestamnp.after(dateStartTimestamp)
                || dateEndTimestamnp.equals(dateStartTimestamp))) {
            return new ModelAndView("/pages/carAvailable","model",model);
        } else {
            return new ModelAndView("/pages/carInaccessible","cars",allCars);
        }
    }

}

