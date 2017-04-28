package com.headkeeper.controller.impl;

import com.headkeeper.controller.HomeController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllerImpl implements HomeController{

    public String getHome() {
        return "home";
    }


}
