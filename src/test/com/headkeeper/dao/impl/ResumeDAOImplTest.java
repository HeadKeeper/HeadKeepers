package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.*;
import com.headkeeper.dao.util.EntityPreprocessor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResumeDAOImplTest {

    @InjectMocks
    private ResumeDAOImpl resumeDAO;

    @Mock
    private SessionFactory sessionFactory;

    private Session session;
    private Query query;
    private User user;
    private UserResume resume;
    private List list;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        query = mock(Query.class);
        user = mock(User.class);
        resume = mock(UserResume.class);
        list = mock(List.class);
    }

    @Test
    public void addNewResume() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        resumeDAO.addNewResume(new UserResume());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    //WORKING
    @Test
    public void addResumeAchievement() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.load(eq(UserResume.class), anyInt())).thenReturn(resume);
        when(session.createQuery(anyString())).thenReturn(query);
        resumeDAO.addResumeAchievement(new ResumeAchievement(), 1);
        verifyThatSessionUpdateWasCalled();
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

    private void givenSessionReturnsUser() {
        when(session.get(eq(User.class), anyInt())).thenReturn(user);
    }

    private void givenSessionReturnsUserResume() {
        when(session.get(eq(UserResume.class), anyInt())).thenReturn(resume);
    }

    private void verifyThatSessionSaveWasCalled() {
        verify(session, times(1)).save(any());
    }

    private void verifyThatSessionUpdateWasCalled() {
        verify(session, times(1)).update(any());
    }

    private void verifyThatGetCurrentSessionWasCalled() {
        verify(sessionFactory, times(1)).getCurrentSession();
    }

    private void givenSessionFactoryReturnsCurrentSession() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

}