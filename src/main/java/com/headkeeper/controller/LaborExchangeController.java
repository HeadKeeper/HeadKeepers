package com.headkeeper.controller;

import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.VacancyView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface LaborExchangeController {

    /* ------------------------------------------ RESUME CONTROLLING ------------------------------------------- */

    @RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
    @ResponseBody
    UserResumeView getResumeById(@PathVariable int id);

    @RequestMapping(value = "/search/vacancies/{title}")
    @ResponseBody
    List<VacancyView> getVacancyByTitle(@PathVariable String title);

    @RequestMapping(value = "/search/vacancies/{companyname}")
    @ResponseBody
    CompanyInfoView getCompanyByCompanyName(@PathVariable String companyName);

    @RequestMapping(value = "/add/resume", method = RequestMethod.POST)
    void addNewResume(@RequestBody UserResumeView resume);

    @RequestMapping(value = "/add/vacancy", method = RequestMethod.POST)
    void addNewVacancy(@RequestBody VacancyView vacancy);

    @RequestMapping(value = "/edit/resume", method = RequestMethod.POST)
    void editResume(@RequestBody UserResumeView resume);

    @RequestMapping(value = "/edit/vacancy", method = RequestMethod.POST)
    void editVacancy(@RequestBody VacancyView vacancy);

    @RequestMapping(value = "/delete/resume/{id}", method = RequestMethod.POST)
    void deleteResume(@PathVariable int id);

    @RequestMapping(value = "/delete/vacancy/{id}", method = RequestMethod.POST)
    void deleteVacancy(@PathVariable int id);
}
