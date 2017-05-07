package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
        list = mock(List.class);
        resume = mock(UserResume.class, RETURNS_DEEP_STUBS);
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
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.addResumeAchievement(new ResumeAchievement(), 1);

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addAdditionalEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.load(eq(UserResume.class), anyInt())).thenReturn(resume);
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.addAdditionalEducation(new ResumeAdditionalEducation(), 1);

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addContactInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.load(eq(UserResume.class), anyInt())).thenReturn(resume);
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.addContactInfo(new ResumeContactInfo(), 1);

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.load(eq(UserResume.class), anyInt())).thenReturn(resume);
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.addEducation(new ResumeEducation(), 1);

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addLanguage() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.load(eq(UserResume.class), anyInt())).thenReturn(resume);
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.addLanguage(new ResumeLanguage(), 1);

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addPhoto() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.load(eq(UserResume.class), anyInt())).thenReturn(resume);
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.addPhoto(new ResumePhoto(), 1);

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addWorkExperience() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.load(eq(UserResume.class), anyInt())).thenReturn(resume);
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.addWorkExperience(new ResumeWorkExperience(), 1);

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }



    @Test
    public void getResumeById() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        UserResume userResume = resumeDAO.getResumeById(1);
        Assert.assertNotNull(userResume);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getResumeForUser() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        List<UserResume> values = resumeDAO.getResumeForUser(1);
        Assert.assertNotNull(values);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateResume() throws Exception {
        givenSessionFactoryReturnsCurrentSession();
        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.updateResume(1, new UserResume());

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateWorkExperience() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.updateWorkExperience(1, new ResumeWorkExperience());

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateResumeAchievement() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.updateResumeAchievement(1, new ResumeAchievement());

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateAdditionalEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.updateAdditionalEducation(1, new ResumeAdditionalEducation());

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateContactInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.updateContactInfo(1, new ResumeContactInfo());

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.updateEducation(1, new ResumeEducation());

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updatePhoto() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.updatePhoto(1, new ResumePhoto());

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteResume() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deleteResume(1);

        verifyThatSessionDeleteWasCalled();
    }

    @Test
    public void deleteResumeAchievement() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deleteResumeAchievement(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteAdditionalEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deleteAdditionalEducation(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteContactInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deleteContactInfo(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteEducation() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deleteEducation(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteLanguage() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deleteLanguage(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deletePhoto() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deletePhoto(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteWorkExperience() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUserResume();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        resumeDAO.deleteWorkExperience(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    private void givenSessionReturnsUserResume() {
        when(session.get(eq(UserResume.class), anyInt())).thenReturn(resume);
    }

    private void verifyThatSessionSaveWasCalled() {
        verify(session, times(1)).save(any());
    }

    private void verifyThatSessionDeleteWasCalled() {
        verify(session, times(1)).delete(any());
    }

    private void verifyThatSessionUpdateWasCalled() {
        verify(session, times(1)).update(any());
    }

    private void verifyThatGetCurrentSessionWasCalled() {
        verify(sessionFactory, times(1)).getCurrentSession();
    }

    private void givenSessionFactoryReturnsNotEmptyList() {
        when(session.createQuery(anyString()).list()).thenReturn(list);
        when(list.size()).thenReturn(1);
    }

    private void givenSessionFactoryReturnsCurrentSession() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

}