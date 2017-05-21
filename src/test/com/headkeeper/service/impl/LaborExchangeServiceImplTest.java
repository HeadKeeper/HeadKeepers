package com.headkeeper.service.impl;

import com.headkeeper.bean.entity.ResumeAdditionalEducation;
import com.headkeeper.bean.view.*;
import com.headkeeper.dao.CertificateDAO;
import com.headkeeper.dao.ResumeDAO;
import com.headkeeper.dao.SkillDAO;
import com.headkeeper.dao.impl.VacancyDAOImpl;
import io.jsonwebtoken.lang.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LaborExchangeServiceImplTest {

    @InjectMocks
    private LaborExchangeServiceImpl laborExchangeService;

    @Mock
    private VacancyDAOImpl vacancyDAO;
    @Mock
    private ResumeDAO resumeDAO;
    @Mock
    private SkillDAO skillDAO;
    @Mock
    private CertificateDAO certificateDAO;

    private VacancyView vacancyView;

    @Before
    public void setUp() throws Exception {
        vacancyView = mock(VacancyView.class);
    }

    @Test
    public void createVacancy() throws Exception {
        //laborExchangeService.createVacancy(new VacancyView());
        //verify(vacancyDAO, times(1)).addVacancy(any(), anyInt());
    }

    @Test
    public void updateVacancy() throws Exception {
        laborExchangeService.updateVacancy(1, new VacancyView());
        verify(vacancyDAO, times(1)).updateVacancy(anyInt(), any());
    }

    @Test
    public void getVacancy() throws Exception {
        VacancyView vacancy = laborExchangeService.getVacancy(1);
        Assert.notNull(vacancy);
        verify(vacancyDAO, times(1)).getVacancyById(anyInt());
    }

    @Test
    public void getAllVacancies() throws Exception {
        List list = laborExchangeService.getAllVacancies();
        Assert.notNull(list);
        verify(vacancyDAO, times(1)).getAllVacancies();
    }

    @Test
    public void getVacanciesForEmployer() throws Exception {
        List list = laborExchangeService.getVacanciesForEmployer(1);
        Assert.notNull(list);
        verify(vacancyDAO, times(1)).getVacanciesById(anyInt());
    }

    @Test
    public void setVacancyActiveStatus() throws Exception {
        laborExchangeService.setVacancyActiveStatus(1, true);
        verify(vacancyDAO, times(1)).updateVacancy(anyInt(), anyBoolean());
    }

    @Test
    public void deleteVacancy() throws Exception {
        laborExchangeService.deleteVacancy(1);
        verify(vacancyDAO, times(1)).deleteVacancy(anyInt());
    }

    @Test
    public void createResume() throws Exception {
        //laborExchangeService.createResume(new UserResumeView());
        //verify(resumeDAO, times(1)).addNewResume(any());
    }

    @Test
    public void updateResume() throws Exception {
        laborExchangeService.updateResume(1, new UserResumeView());
        verify(resumeDAO, times(1)).updateResume(anyInt(), any());
    }

    @Test
    public void getResume() throws Exception {
        UserResumeView resumeView = laborExchangeService.getResume(1);
        Assert.notNull(resumeView);
        verify(resumeDAO, times(1)).getResumeById(anyInt());
    }

    @Test
    public void getResumesForUser() throws Exception {
        List list = laborExchangeService.getResumesForUser(1);
        Assert.notNull(list);
        verify(resumeDAO, times(1)).getResumeForUser(anyInt());
    }

    @Test
    public void setResumeStatus() throws Exception {
        laborExchangeService.setResumeStatus(1, true);
        verify(resumeDAO, times(1)).updateResumeStatus(anyInt(), anyBoolean());
    }

    @Test
    public void deleteResume() throws Exception {
        laborExchangeService.deleteResume(1);
        verify(resumeDAO, times(1)).deleteResume(anyInt());
    }

    @Test
    public void createSkillForUser() throws Exception {
        laborExchangeService.createSkillForUser(1, new SkillView());
        verify(skillDAO, times(1)).addSkillToUser(anyInt(), any());
    }

    @Test
    public void createSkillForVacancy() throws Exception {
        laborExchangeService.createSkillForVacancy(1, new SkillView());
        verify(skillDAO, times(1)).addSkillToVacancy(anyInt(), any());
    }

    @Test
    public void updateSkill() throws Exception {
        laborExchangeService.updateSkill(1, new SkillView());
        verify(skillDAO, times(1)).updateSkill(anyInt(), any());
    }

    @Test
    public void getSkillsForUser() throws Exception {
        List list = laborExchangeService.getSkillsForUser(1);
        Assert.notNull(list);
        verify(skillDAO, times(1)).getSkillsForUser(anyInt());
    }

    @Test
    public void getSkillsForVacancy() throws Exception {
        List list = laborExchangeService.getSkillsForVacancy(1);
        Assert.notNull(list);
        verify(skillDAO, times(1)).getSkillsForVacancy(anyInt());
    }

    @Test
    public void deleteSkill() throws Exception {
        laborExchangeService.deleteSkill(1);
        verify(skillDAO, times(1)).deleteSkill(anyInt());
    }

    @Test
    public void deleteEducation() throws Exception {
        laborExchangeService.deleteEducation(1);
        verify(resumeDAO, times(1)).deleteEducation(anyInt());
    }

    @Test
    public void updateAdditionalEducation() throws Exception {
        laborExchangeService.updateAdditionalEducation(1, new ResumeAdditionalEducationView());
        verify(resumeDAO, times(1)).updateAdditionalEducation(anyInt(), any());
    }

    @Test
    public void getCertificatesForUser() throws Exception {
        List list = laborExchangeService.getCetificatesForUser(1);
        Assert.notNull(list);
        verify(certificateDAO, times(1)).getCertificatesForUser(anyInt());
    }

    @Test
    public void updateAchievement() throws Exception {
        laborExchangeService.updateAchievement(1, new ResumeAchievementView());
        verify(resumeDAO, times(1)).updateResumeAchievement(anyInt(), any());;
    }

    @Test
    public void deleteWorkExperience() throws Exception {
        laborExchangeService.deleteWorkExperience(1);
        verify(resumeDAO, times(1)).deleteWorkExperience(anyInt());
    }

    @Test
    public void deleteAdditionalEducation() throws Exception {
        laborExchangeService.deleteAdditionalEducation(1);
        verify(resumeDAO, times(1)).deleteAdditionalEducation(anyInt());
    }

    @Test
    public void deleteLanguage() throws Exception {
        laborExchangeService.deleteLanguage(1);
        verify(resumeDAO, times(1)).deleteLanguage(anyInt());
    }

    @Test
    public void deleteCertificate() throws Exception {
        laborExchangeService.deleteCertificate(1);
        verify(certificateDAO, times(1)).deleteCertificate(anyInt());
    }

    @Test
    public void deletePhoto() throws Exception {
        laborExchangeService.deleteWorkExperience(1);
        verify(resumeDAO, times(1)).deleteWorkExperience(anyInt());
    }

    @Test
    public void deleteContactInfo() throws Exception {
        laborExchangeService.deleteWorkExperience(1);
        verify(resumeDAO, times(1)).deleteWorkExperience(anyInt());
    }
}