package com.headkeeper.controller.impl;


import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.VacancyView;
import com.headkeeper.controller.LaborExchangeController;
import com.headkeeper.controller.exception.ControllerException;
import com.headkeeper.controller.exception.ExistsControllerException;
import com.headkeeper.controller.exception.NotFoundControllerException;
import com.headkeeper.controller.exception.WrongInputControllerException;
import com.headkeeper.controller.util.Validator;
import com.headkeeper.exception.ResourceNotFoundException;
import com.headkeeper.exception.ValidationException;
import com.headkeeper.security.TokenAuthentication;
import com.headkeeper.security.service.GetTokenService;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.exception.ExistsServiceException;
import com.headkeeper.service.exception.NotFoundServiceException;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.service.exception.WrongInputServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class LaborExchangeControllerImpl implements LaborExchangeController{

    private final LaborExchangeService service;

    @Autowired
    public LaborExchangeControllerImpl(LaborExchangeService service) {
        this.service = service;
    }

    public UserResumeView getResumeById(@PathVariable int id) throws ControllerException {
        try {
            return service.getResume(id);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public List<VacancyView> getVacancyByTitle(@PathVariable String title) throws ControllerException {
        try {
            return service.getVacanciesByTitle(title);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public CompanyInfoView getCompanyByCompanyName(@PathVariable String companyName) throws ControllerException {
        try {
            return service.getCompanyByCompanyName(companyName);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public void addNewResume(@RequestBody UserResumeView resume) throws ControllerException {
        try {
            if (!Validator.validateResume(resume)) {
                throw new ValidationException("Invalid resume data!");
            }
            int userId = getUserId();
            resume.setUserId(userId);
            service.createResume(userId, resume);
        } catch (ExistsServiceException e) {
            throw new ExistsControllerException("User already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public void addNewVacancy(@RequestBody VacancyView vacancy) throws ControllerException {
        try {
            if (!Validator.validatePhoneNumber(vacancy.getPhoneNumber())) {
                throw new ValidationException("Phone number is not valid!");
            }
            if (!Validator.validateVacancy(vacancy)) {
                throw new ValidationException("Invalid vacancy data!");
            }
            int companyId = getUserId();
            vacancy.setId(companyId);
            service.createVacancy(companyId, vacancy);
        } catch (ExistsServiceException e) {
            throw new ExistsControllerException("User already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public void editResume(@RequestBody UserResumeView resume) throws ControllerException {
        try {
            if (!Validator.validateResume(resume)) {
                throw new ValidationException("Invalid resume data!");
            }
            service.updateResume(resume.getId(), resume);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public void editVacancy(@RequestBody VacancyView vacancy) throws ControllerException {
        try {
            if (!Validator.validateVacancy(vacancy)) {
                throw new ValidationException("Invalid vacancy data!");
            }
            service.updateVacancy(vacancy.getId(), vacancy);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public void deleteResume(@PathVariable int id) throws ControllerException {
        try {
            service.deleteResume(id);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public void deleteVacancy(@PathVariable int id) throws ControllerException {
        try {
            service.deleteVacancy(id);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    @Override
    public List<UserResumeView> getResumesByUser(@PathVariable int userId) throws ControllerException {
        try {
            return service.getResumesForUser(userId);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    @Override
    public List<VacancyView> getVacanciesByCompany(@PathVariable int companyId) throws ControllerException {
        try {
            return service.getVacanciesForEmployer(companyId);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    private int getUserId() {
        TokenAuthentication tokenAuthentication;
        tokenAuthentication = (TokenAuthentication) SecurityContextHolder.getContext().getAuthentication();
        return  (int) tokenAuthentication.getDetails();
    }
}
