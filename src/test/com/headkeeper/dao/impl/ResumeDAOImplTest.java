package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;

public class ResumeDAOImplTest {

    @InjectMocks
    private ResumeDAOImpl resumeDAO;

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;
    private Query query;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        query = mock(Query.class);
    }

    @Test
    public void addNewResume() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addNewResume(new UserResume());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addResumeAchievement() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addResumeAchievement(new ResumeAchievement(), anyInt());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addAdditionalEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addAdditionalEducation(new ResumeAdditionalEducation(), anyInt());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addContactInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addContactInfo(new ResumeContactInfo(), anyInt());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addEducation(new ResumeEducation(), anyInt());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addLanguage() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addLanguage(new ResumeLanguage(), anyInt());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addPhoto() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addPhoto(new ResumePhoto(), anyInt());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addWorkExperience() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addWorkExperience(new ResumeWorkExperience(), anyInt());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    //-----------------------------------------------------

    @Test
    public void getResumeById() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumeAchievements() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getAdditionalEducations() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getContactInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumeEducations() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumeLanguages() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumePhotos() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumeWorkExperience() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumeForUser() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumeWorkExperiences() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateResumeStatus() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateResume() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateLanguage() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateWorkExperience() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateResumeAchievement() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateAdditionalEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateContactInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updatePhoto() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteResume() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteResumeAchievement() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteAdditionalEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteContactInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteLanguage() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deletePhoto() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteWorkExperience() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        verifyThatGetCurrentSessionWasCalled();
    }

    private void verifyThatSessionSaveWasCalled() {
        verify(session, times(1)).save(any());
    }

    private void verifyThatGetCurrentSessionWasCalled() {
        verify(sessionFactory, times(1)).getCurrentSession();
    }

    private void givenSessionFactoryReturnsCurrentSession() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

}