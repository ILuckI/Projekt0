package com.project0.ProjektGrupowy.controller;

import com.project0.ProjektGrupowy.dto.AccessoryDto;
import com.project0.ProjektGrupowy.dto.PriceDto;
import com.project0.ProjektGrupowy.service.AccessoryService;
import com.project0.ProjektGrupowy.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CennikController {

    @Autowired
    private PriceService priceService;

    @Autowired
    private AccessoryService accessoryService;

    @RequestMapping ("/cennik")
    public ModelAndView findPrice(Model model) {
        List<PriceDto> allPrices = priceService.getAllPrices();
        List<AccessoryDto> allAccessories = accessoryService.getAllAccessories();
        Map<String, Object> modelMap = new HashMap<String, Object>();
        model.addAttribute("prices", allPrices);
        model.addAttribute("accessories", allAccessories);
        return new ModelAndView("pages/cennik", "model", model);
    }

}
