package com.headkeeper.controller.impl;


import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.UserResumeView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.bean.view.VacancyView;
import com.headkeeper.bean.view.document_gen.*;
import com.headkeeper.controller.DocumentController;
import com.headkeeper.service.LaborExchangeService;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.util.documents.DocumentTypes;
import com.headkeeper.util.documents.generate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class DocumentControllerImpl implements DocumentController {

    @Autowired
    private UserService userService;

    @Autowired
    private LaborExchangeService laborExchangeService;

    @Override
    public ModelAndView generateCompaniesDocument(@PathVariable String type) {
        try {
            List<CompanyInfoView> companyInfoList = userService.getAllCompanies();
            CompanyListView companyListView = new CompanyListView();
            for (int i = 0; i < companyInfoList.size(); i++) {
                ShortCompanyInfoView shortInfo = new ShortCompanyInfoView();
                shortInfo.setId(companyInfoList.get(i).getId());
                shortInfo.setName(companyInfoList.get(i).getName());
                shortInfo.setAddress(companyInfoList.get(i).getAddress());
                companyListView.getCompanies().add(shortInfo);
            }
            return generateModel(type, new Companies(), companyListView);
        } catch (ServiceException exception) {
            return null;
        }
    }

    @Override
    public ModelAndView generateResumesDocument(@PathVariable String type) {
        try {
            List<UserResumeView> resumes = laborExchangeService.getAllResumes();
            UserResumesList userResumesList = new UserResumesList();
            for (int i = 0; i < resumes.size(); i++) {
                ShortUserResumeView shortInfo = new ShortUserResumeView();
                shortInfo.setId(resumes.get(i).getId());
                shortInfo.setFirstName(resumes.get(i).getFirstName());
                shortInfo.setLastName(resumes.get(i).getLastName());
                userResumesList.getResumes().add(shortInfo);
            }
            return generateModel(type, new Resumes(), userResumesList);
        } catch (ServiceException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public ModelAndView generateSalariesPetitions(@PathVariable String type) {
        try {
            List<VacancyView> vacancies = laborExchangeService.getAllVacancies();
            SalaryListView salaryListView = new SalaryListView();
            for (int i = 0; i < vacancies.size(); i++) {
                ShortSalaryView shortInfo = new ShortSalaryView();
                shortInfo.setVacancyId(vacancies.get(i).getId());
                shortInfo.setMinSalary(vacancies.get(i).getMinSalary());
                shortInfo.setMaxSalary(vacancies.get(i).getMaxSalary());
                salaryListView.getSalaries().add(shortInfo);
            }
            return generateModel(type, new Salaries(), salaryListView);
        } catch (ServiceException exception) {
            return null;
        }
    }

    @Override
    public ModelAndView generateUsersDocument(@PathVariable String type) {
        try {
            List<UserView> users = userService.getAllUsers();
            UserListView userListView = new UserListView();
            for (int i = 0; i < users.size(); i++) {
                ShortUserInformationView shortInfo = new ShortUserInformationView();
                shortInfo.setId(users.get(i).getId());
                shortInfo.setEmail(users.get(i).getEmail());
                shortInfo.setPassword(users.get(i).getPassword());
                shortInfo.setNickname(users.get(i).getNickname());
                shortInfo.setRole(users.get(i).getRole().getValue());
                shortInfo.setActive(users.get(i).isActive());
                userListView.getUsers().add(shortInfo);
            }
            return generateModel(type, new Users(), userListView);
        } catch (ServiceException exception) {
            return null;
        }
    }

    @Override
    public ModelAndView generateVacanciesDocument(@PathVariable String type) {
        try {
            List<VacancyView> vacancies = laborExchangeService.getAllVacancies();
            VacancyListView vacancyListView = new VacancyListView();
            for (int i = 0; i < vacancies.size(); i++) {
                ShortVacancyView shortInfo = new ShortVacancyView();
                shortInfo.setId(vacancies.get(i).getId());
                shortInfo.setTitle(vacancies.get(i).getTitle());
                shortInfo.setUserId(vacancies.get(i).getUser().getId());
                vacancyListView.getVacancies().add(shortInfo);
            }
            return generateModel(type, new Vacancies(), vacancyListView);
        } catch (ServiceException exception) {
            return null;
        }
    }

    private ModelAndView generateModel(String type, Object object, Object model) {
        HashMap<String, Object> newModel = new HashMap<>();
        newModel.put("object", object);
        newModel.put("model", model);
        return new ModelAndView(DocumentTypes.getType(type), "model", newModel);
    }
}
