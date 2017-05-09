package com.headkeeper.controller.impl;


import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.VacancyView;
import com.headkeeper.controller.LaborExchangeController;
import com.headkeeper.controller.util.Validator;
import com.headkeeper.exception.ResourceNotFoundException;
import com.headkeeper.exception.ValidationException;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LaborExchangeControllerImpl implements LaborExchangeController{

    private final LaborExchangeService service;

    @Autowired
    public LaborExchangeControllerImpl(LaborExchangeService service) {
        this.service = service;
    }

    public UserResumeView getResumeById(@PathVariable int id) {
        UserResumeView resume;
        try {
            resume = service.getResume(id);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }

        if (resume == null) {
            throw new ResourceNotFoundException();
        }
        //TODO: Write
        System.out.println(resume.getId() + " " + resume.getAdditionalInformation());
        return null;
    }

    public void addNewResume(@RequestBody UserResumeView resume) {
        try {
            if (!Validator.validateResume(resume)) {
                throw new ValidationException("Invalid resume data!");
            }
            service.createResume(resume);
        } catch (ServiceException exception) {

        }
    }

    public void addNewVacancy(@RequestBody VacancyView vacancy) {
        try {
            if (!Validator.validatePhoneNumber(vacancy.getPhoneNumber())) {
                throw new ValidationException("Phone number is not valid!");
            }
            if (!Validator.validateVacancy(vacancy)) {
                throw new ValidationException("Invalid vacancy data!");
            }
            service.createVacancy(vacancy);
        } catch (ServiceException exception) {

        }
    }

    public void editResume(@RequestBody UserResumeView resume) {
        try {
            if (!Validator.validateResume(resume)) {
                throw new ValidationException("Invalid resume data!");
            }
            service.updateResume(resume.getId(), resume);
        } catch (ServiceException exception) {

        }
    }

    public void editVacancy(@RequestBody VacancyView vacancy) {
        try {
            if (!Validator.validateVacancy(vacancy)) {
                throw new ValidationException("Invalid vacancy data!");
            }
            service.updateVacancy(vacancy.getId(), vacancy);
        } catch (ServiceException exception) {

        }
    }

    public void deleteResume(@PathVariable int id) {
        try {
            service.deleteResume(id);
        } catch (ServiceException exception) {

        }
    }

    public void deleteVacancy(@PathVariable int id) {
        try {
            service.deleteVacancy(id);
        } catch (ServiceException exception) {

        }
    }
}
