package com.headkeeper.controller.impl;


import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.VacancyView;
import com.headkeeper.controller.LaborExchangeController;
import com.headkeeper.controller.util.Validator;
import com.headkeeper.exception.ResourceNotFoundException;
import com.headkeeper.exception.ValidationException;
import com.headkeeper.security.TokenAuthentication;
import com.headkeeper.security.service.GetTokenService;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class LaborExchangeControllerImpl implements LaborExchangeController{

    private final LaborExchangeService service;
    private GetTokenService getTokenService;

    @Autowired
    public void setGetTokenService(GetTokenService getTokenService) {
        this.getTokenService = getTokenService;
    }

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

    public List<VacancyView> getVacancyByTitle(@PathVariable String title) {
        try {
            return service.getVacanciesByTitle(title);
        } catch (ServiceException exception) {
            return null;
        }
    }

    public CompanyInfoView getCompanyByCompanyName(@PathVariable String companyName) {
        try {
            return service.getCompanyByCompanyName(companyName);
        } catch (ServiceException exception) {
            return null;
        }
    }

    public void addNewResume(@RequestBody UserResumeView resume) {
        try {
            if (!Validator.validateResume(resume)) {
                throw new ValidationException("Invalid resume data!");
            }
            TokenAuthentication tokenAuthentication;
            tokenAuthentication = (TokenAuthentication) SecurityContextHolder.getContext().getAuthentication();
            resume.setId((int)tokenAuthentication.getDetails());
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
            TokenAuthentication tokenAuthentication;
            tokenAuthentication = (TokenAuthentication) SecurityContextHolder.getContext().getAuthentication();
            vacancy.setId((int)tokenAuthentication.getDetails());
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
