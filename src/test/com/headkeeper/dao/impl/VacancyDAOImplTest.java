package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.entity.Vacancy;
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

import java.util.Collection;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VacancyDAOImplTest {
    @InjectMocks
    private VacancyDAOImpl vacancyDAO;

    @Mock
    private SessionFactory sessionFactory;

    private Session session;
    private Query query;
    private User user;
    private Vacancy vacancy;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        query = mock(Query.class);
        user = mock(User.class);
        vacancy = mock(Vacancy.class);
    }

    @Test
    public void addVacancy() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        vacancyDAO.addVacancy(new Vacancy(), 1);

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getVacancyById() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionFactoryReturnsVacancy();
        Vacancy vacancy = vacancyDAO.getVacancyById(1);
        Assert.assertNotNull(vacancy);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getAllVacancies() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        Collection list = vacancyDAO.getAllVacancies();
        Assert.assertNotNull(list);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getVacanciesByStatus() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        Collection list = vacancyDAO.getVacanciesByStatus(true);
        Assert.assertNotNull(list);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getVacanciesById() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        Collection list = vacancyDAO.getVacanciesById(1);
        Assert.assertNotNull(list);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteVacancy() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        vacancyDAO.deleteVacancy(1);

        verifyThatSessionDeleteWasCalled();
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

    private void givenSessionFactoryReturnsVacancy() {
        when(session.get(eq(Vacancy.class), anyInt())).thenReturn(vacancy);
    }

}