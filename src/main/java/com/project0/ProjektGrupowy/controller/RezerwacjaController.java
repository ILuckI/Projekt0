package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.Entities.Car;
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
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

        if (carRentService.isCarFree(carClass, dateT, date2T)
                && (date2T.after(dateT) || date2T.equals(dateT))) {

            CarRentDto carRentDto1 = new CarRentDto( carService.findCarIdByName(carClass),dateT, date2T);
            carRentService.save(carRentDto1);
            return new ModelAndView("/pages/accept");
        } else {
            List<CarDto> allCars = carService.getAllCars();
            allCars.sort(Comparator.comparing(CarDto::getCarName));
            return new ModelAndView("/pages/carInaccessible", "cars", allCars);
        }
    }
}
