package com.headkeeper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String getHome();
}
