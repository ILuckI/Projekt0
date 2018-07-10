package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.Entities.Car;
import com.project0.ProjektGrupowy.dto.CarDto;
import com.project0.ProjektGrupowy.dto.CarRentDto;
import com.project0.ProjektGrupowy.dto.ClientDto;
import com.project0.ProjektGrupowy.service.*;
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

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccessoryService accessoryService;

    @RequestMapping("/rezerwacja")
    public ModelAndView home() {
        List<CarDto> allCars = carService.getAllCars();
        allCars.sort(Comparator.comparing(CarDto::getCarName));
        return new ModelAndView("pages/rezerwacja", "cars", allCars);
    }

    @PostMapping("/acceptance")
    public ModelAndView acceptance(@RequestParam("carClass") String carName,
                                   @RequestParam("date") String dateStart,
                                   @RequestParam("date1") String dateEnd,
                                   @RequestParam("name") String name,
                                   @RequestParam("address") String address,
                                   @RequestParam("email") String email,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("dowod") String dowod,
                                   @RequestParam(value = "abroad", required = false, defaultValue = "No") String abroad,
                                   @RequestParam(value = "navigation", required = false, defaultValue = "No") String navigation,
                                   @RequestParam(value = "booster", required = false, defaultValue = "No") String booster,
                                   @RequestParam(value = "driver", required = false, defaultValue = "No") String driver,
                                   @RequestParam(value = "acceptMail", required = false, defaultValue = "No") String acceptMail,
                                   @RequestParam(value = "acceptSMS", required = false, defaultValue = "No") String acceptSMS,
                                   Model model) {

        String startString = dateStart.concat(" 00:00:00.00");
        String endString = dateEnd.concat(" 00:00:00.00");

        Timestamp startTimestamp = Timestamp.valueOf(startString);
        Timestamp endTimestamp = Timestamp.valueOf(endString);

        if (carRentService.isCarFree(carName, startTimestamp, endTimestamp)
                && (endTimestamp.after(startTimestamp) || endTimestamp.equals(startTimestamp))) {

//            SAVE TO DATABASE
            if (clientService.findClientByAllData(name, address, email, phone, dowod) == null) {
                ClientDto clientDto1 = new ClientDto(name,address,email,phone,dowod, acceptMail, acceptSMS);
                clientService.save(clientDto1);
            }

            long clientId = clientService.findClientIdByAllData(name, address, email, phone, dowod);

            CarRentDto carRentDto1 = new CarRentDto(carService.findCarIdByName(carName), startTimestamp, endTimestamp, clientId, abroad,navigation,booster,driver);
            carRentService.save(carRentDto1);

//            COUNTING PRICE
            long carClassId = carService.findCarClassIdByCarName(carName);
            int countDays = dateService.countDays(dateStart, dateEnd);

            int price = 0;
            int abroadPrice = 0;
            int boosterPrice = 0;
            int navigationPrice = 0;
            int driverPrice = 0;

            if (countDays <= 3) {
                price = priceService.get3DaysPriceByCarClassId(carClassId);
            } else if (countDays <= 7) {
                price = priceService.get7DaysPriceByCarClassId(carClassId);
            } else {
                price = priceService.get7DaysMorePriceByCarClassId(carClassId);
            }

//            CHECKING ACCESSORIES
            if (abroad.equals("Yes"))
                abroadPrice = countDays * accessoryService.findPriceByAccessoryName("Uzytkowanie poza granica");
            if (navigation.equals("Yes"))
                navigationPrice = countDays * accessoryService.findPriceByAccessoryName("Nawigacja");
            if (booster.equals("Yes"))
                boosterPrice = countDays * accessoryService.findPriceByAccessoryName("Fotelik dla dziecka");
            if (driver.equals("Yes"))
                driverPrice = countDays * accessoryService.findPriceByAccessoryName("Dodatkowy kierowca");

            int priceCarRent = price * countDays;
            int totalPrice = priceCarRent + abroadPrice + navigationPrice + boosterPrice + driverPrice;
            int deposit = priceService.getDepositByCarClassId(carClassId);

            Map<String, Object> modelMap = new HashMap<String, Object>();
            model.addAttribute("countDays", countDays);
            model.addAttribute("priceCarRent", priceCarRent);
            model.addAttribute("abroad", abroadPrice);
            model.addAttribute("navigation", navigationPrice);
            model.addAttribute("booster", boosterPrice);
            model.addAttribute("driver", driverPrice);
            model.addAttribute("totalPrice", totalPrice);
            model.addAttribute("deposit", deposit);

            return new ModelAndView("/pages/accept", "model", model);
        } else {
            List<CarDto> allCars = carService.getAllCars();
            allCars.sort(Comparator.comparing(CarDto::getCarName));
            return new ModelAndView("/pages/carInaccessible", "cars", allCars);
        }
    }
}
