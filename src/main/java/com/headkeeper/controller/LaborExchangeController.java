package com.headkeeper.controller;

import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.VacancyView;
import com.headkeeper.controller.exception.ControllerException;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface LaborExchangeController {

    /* ------------------------------------------ RESUME CONTROLLING ------------------------------------------- */

    @RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
    @ResponseBody
    UserResumeView getResumeById(@PathVariable int id) throws ControllerException;

    @RequestMapping(value = "/search/vacancies/{title}")
    @ResponseBody
    List<VacancyView> getVacancyByTitle(@PathVariable String title) throws ControllerException;

    @RequestMapping(value = "/search/vacancies/{companyName}")
    @ResponseBody
    CompanyInfoView getCompanyByCompanyName(@PathVariable String companyName) throws ControllerException;

    @RequestMapping(value = "/add/resume", method = RequestMethod.POST)
    void addNewResume(@RequestBody UserResumeView resume) throws ControllerException;

    @RequestMapping(value = "/add/vacancy", method = RequestMethod.POST)
    void addNewVacancy(@RequestBody VacancyView vacancy) throws ControllerException;

    @RequestMapping(value = "/edit/resume", method = RequestMethod.POST)
    void editResume(@RequestBody UserResumeView resume) throws ControllerException;

    @RequestMapping(value = "/edit/vacancy", method = RequestMethod.POST)
    void editVacancy(@RequestBody VacancyView vacancy) throws ControllerException;

    @RequestMapping(value = "/delete/resume/{id}", method = RequestMethod.POST)
    void deleteResume(@PathVariable int id) throws ControllerException;

    @RequestMapping(value = "/delete/vacancy/{id}", method = RequestMethod.POST)
    void deleteVacancy(@PathVariable int id) throws ControllerException;

    @RequestMapping(value = "/users/{userId}/resumes", method = RequestMethod.GET)
    @ResponseBody
    List<UserResumeView> getResumesByUser(@PathVariable int userId) throws ControllerException;

    @RequestMapping(value = "/companies/{companyId}/vacancies", method = RequestMethod.GET)
    @ResponseBody
    List<VacancyView> getVacanciesByCompany(@PathVariable int companyId) throws ControllerException;

}
