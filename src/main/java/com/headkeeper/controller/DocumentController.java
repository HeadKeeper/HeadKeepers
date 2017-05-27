package com.headkeeper.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public interface DocumentController {

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/documents/companies/{type}")
    ModelAndView generateCompaniesDocument(@PathVariable String type);

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/documents/resumes/{type}")
    ModelAndView generateResumesDocument(@PathVariable String type);

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/documents/salaries/{type}")
    ModelAndView generateSalariesPetitions(@PathVariable String type);

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/documents/users/{type}")
    ModelAndView generateUsersDocument(@PathVariable String type);

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/documents/vacancies/{type}")
    ModelAndView generateVacanciesDocument(@PathVariable String type);
}
