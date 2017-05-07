package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.EmployerToResume;
import com.headkeeper.bean.entity.ResumeToVacancy;
import com.headkeeper.bean.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserInteractionEmployerDAOImplTest {

    @InjectMocks
    private UserInteractionEmployerDAOImpl userInteractionEmployerDAO;

    @Mock
    private SessionFactory sessionFactory;

    private Session session;
    private Query query;
    private User user;
    private EmployerToResume employerToResume;
    private ResumeToVacancy resumeToVacancy;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        query = mock(Query.class);
        user = mock(User.class);
        employerToResume = mock(EmployerToResume.class);
        resumeToVacancy = mock(ResumeToVacancy.class);
    }

    @Test
    public void createEmployerRequestToResume() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        userInteractionEmployerDAO.createEmployerRequestToResume(1, 1);

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void createRequestToVacancy() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        userInteractionEmployerDAO.createRequestToVacancy(1, 1);

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    private void givenSessionReturnsUser() {
        when(session.get(eq(User.class), anyInt())).thenReturn(user);
    }

    private void verifyThatSessionSaveWasCalled() {
        verify(session, times(1)).save(any());
    }

    private void verifyThatSessionSaveOrUpdateWasCalled() {
        verify(session, times(1)).saveOrUpdate(any());
    }

    private void verifyThatSessionMergeWasCalled() {
        verify(session, times(1)).merge(any());
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

    private void givenSessionFactoryReturnsCurrentSession() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
    }

    private void givenSessionReturnsEmployerToResume() {
        when(session.get(eq(EmployerToResume.class), anyInt())).thenReturn(employerToResume);
    }

    private void givenSessionReturnsResumeToVacancy() {
        when(session.get(eq(ResumeToVacancy.class), anyInt())).thenReturn(resumeToVacancy);
    }

}