package com.headkeeper.controller;

import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.VacancyView;
import org.springframework.web.bind.annotation.*;

public interface LaborExchangeController {

    /* ------------------------------------------ RESUME CONTROLLING ------------------------------------------- */

    @RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
    @ResponseBody
    UserResumeView getResumeById(@PathVariable int id);

    @RequestMapping(value = "/add/resume", method = RequestMethod.POST)
    void addNewResume(@RequestBody UserResumeView resume);

    @RequestMapping(value = "/add/vacancy", method = RequestMethod.POST)
    void addNewVacancy(@RequestBody VacancyView vacancy);
}
