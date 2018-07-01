package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.PriceDto;
import com.project0.ProjektGrupowy.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Luck
 */
@Controller
public class CennikController {

    @Autowired
    private PriceService priceService;

    @RequestMapping("/cennik")
    public String home() {
        return "pages/cennik";
    }

//    @GetMapping("/cennik")
//    public ModelAndView findPrice() {
//        List<PriceDto> allPrices = priceService.getAllPrices();
//        return new ModelAndView("cennik", "prices", allPrices);
//    }

}
