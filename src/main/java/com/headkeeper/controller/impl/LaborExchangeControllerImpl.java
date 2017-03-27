package com.headkeeper.controller.impl;


import com.headkeeper.bean.entity.UserResume;
import com.headkeeper.controller.LaborExchangeController;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.VacancyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LaborExchangeControllerImpl implements LaborExchangeController{

    @Autowired
    private ResumeDAO resumeDAO;

    public UserResume getResumeById(@PathVariable int id) {
        UserResume resume = resumeDAO.getResumeById(id);
        System.out.println(resume.getId() + " " + resume.getAdditionalInformation());
        return null;
    }

    public String getResumePage() {
        return "resume";
    }

    public void addNewResume(@RequestBody UserResume resume) {

    }
}
