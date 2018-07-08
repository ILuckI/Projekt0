package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.Entities.Car;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.dto.CarRentDto;
import com.project0.ProjektGrupowy.service.CarRentService;
import com.project0.ProjektGrupowy.service.CarService;
import com.project0.ProjektGrupowy.service.DateService;
import com.project0.ProjektGrupowy.service.PriceService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private DateService dateService;

    @Autowired
    private PriceService priceService;

    @RequestMapping("/rezerwacja")
    public ModelAndView home() {
        List<CarDto> allCars = carService.getAllCars();
        allCars.sort(Comparator.comparing(CarDto::getCarName));
        return new ModelAndView("pages/rezerwacja", "cars", allCars);
    }

    @PostMapping("/acceptance")
    public ModelAndView acceptance(@RequestParam("carClass") String carName,
                                   @RequestParam("date") String dateStart,
                                   @RequestParam("date1") String dateEnd, Model model) {

        String startString = dateStart.concat(" 00:00:00.00");
        String endString = dateEnd.concat(" 00:00:00.00");

        Timestamp startTimestamp = Timestamp.valueOf(startString);
        Timestamp endTimestamp = Timestamp.valueOf(endString);

        if (carRentService.isCarFree(carName, startTimestamp, endTimestamp)
                && (endTimestamp.after(startTimestamp) || endTimestamp.equals(startTimestamp))) {

//            SAVE TO DATABASE
            CarRentDto carRentDto1 = new CarRentDto( carService.findCarIdByName(carName),startTimestamp, endTimestamp);
            carRentService.save(carRentDto1);

//            COUNT PRICE
            long carClassId = carService.findCarClassIdByCarName(carName);
            int countDays = dateService.countDays(dateStart,dateEnd);

            int price = 0;

            if(countDays <= 3) {
                price = priceService.get3DaysPriceByCarClassId(carClassId);
            } else if (countDays <=7){
                price = priceService.get7DaysPriceByCarClassId(carClassId);
            } else {
                price = priceService.get7DaysMorePriceByCarClassId(carClassId);
            }

            int totalPrice = price * countDays;
            int deposit = priceService.getDepositByCarClassId(carClassId);

            Map<String, Object> modelMap = new HashMap<String, Object>();
            model.addAttribute("countDays", countDays);
            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("deposit", deposit);

            return new ModelAndView("/pages/accept","model",model);
        } else {
            List<CarDto> allCars = carService.getAllCars();
            allCars.sort(Comparator.comparing(CarDto::getCarName));
            return new ModelAndView("/pages/carInaccessible", "cars", allCars);
        }
    }
}
