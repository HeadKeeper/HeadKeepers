package com.headkeeper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 02.03.2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String getHome() {
        return "home";
    }


}
