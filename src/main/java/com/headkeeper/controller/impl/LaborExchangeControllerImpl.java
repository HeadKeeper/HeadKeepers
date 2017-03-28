package com.headkeeper.controller.impl;


import com.headkeeper.bean.entity.UserResume;
import com.headkeeper.controller.LaborExchangeController;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.VacancyDAO;
import com.headkeeper.exception.ResourceNotFoundException;
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

    public UserResume getResumeById(@PathVariable int id) {
        UserResume resume = null;
        try {
            resume = service.getResume(id);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }

        if (resume == null) {
            throw new ResourceNotFoundException();
        }

        System.out.println(resume.getId() + " " + resume.getAdditionalInformation());
        return null;
    }

    public String getResumePage() {
        return "resume";
    }

    public void addNewResume(@RequestBody UserResume resume) {

    }
}
