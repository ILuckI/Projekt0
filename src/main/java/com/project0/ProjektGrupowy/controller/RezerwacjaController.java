package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.dto.CarRentDto;
import com.project0.ProjektGrupowy.service.CarRentService;
import com.project0.ProjektGrupowy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Luck
 */
@Controller
public class RezerwacjaController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarRentService carRentService;

    @RequestMapping("/rezerwacja")
    public ModelAndView home() {
        List<CarDto> allCars = carService.getAllCars();
        allCars.sort(Comparator.comparing(CarDto::getCarName));
        return new ModelAndView("pages/rezerwacja", "cars", allCars);
    }

    @PostMapping("/acceptance")
    public ModelAndView acceptance(@RequestParam("carClass") String carClass,
                                   @RequestParam("date") String dateAccept,
                                   @RequestParam("date1") String dateAccept1, Model model) {
        String One = dateAccept.concat(" 00:00:00.00");
        String Two = dateAccept1.concat(" 00:00:00.00");

        Timestamp dateT = Timestamp.valueOf(One);
        Timestamp date2T = Timestamp.valueOf(Two);

        List<CarDto> allCars = carService.getAllCars();
        allCars.sort(Comparator.comparing(CarDto::getCarName));

        if (carRentService.isCarFree(carClass, dateT, date2T)) {
//            CarRentDto carRentDto = new CarRentDto(4L,dateT, date2T);
//            carRentService.save(carRentDto);
            return new ModelAndView("/pages/accept","cars",allCars);
        } else {
            return new ModelAndView("/pages/carInaccessible", "cars", allCars);
        }
    }
}
