package com.project0.ProjektGrupowy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Luck
 */
@Controller
public class CennikController {
    @RequestMapping("/cennik")
    public String home() {
        return "pages/cennik";
    }
}
