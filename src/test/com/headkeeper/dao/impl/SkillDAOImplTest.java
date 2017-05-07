package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.Skill;
import com.headkeeper.bean.entity.User;
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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SkillDAOImplTest {

    @InjectMocks
    private SkillDAOImpl skillDAO;

    @Mock
    private SessionFactory sessionFactory;

    private Session session;
    private Query query;
    private List list;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        query = mock(Query.class);
        list = mock(List.class);
    }

    @Test
    public void getSkillsForUser() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        List values = skillDAO.getSkillsForUser(1);
        Assert.assertNotNull(values);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getSkillsForVacancy() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        List values = skillDAO.getSkillsForVacancy(1);
        Assert.assertNotNull(values);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateSkill() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        skillDAO.updateSkill(1, new Skill());

        verifyThatSessionUpdateWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteSkill() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        skillDAO.deleteSkill(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
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

    private void givenSessionFactoryReturnsNotEmptyList() {
        when(session.createQuery(anyString()).list()).thenReturn(list);
        when(list.size()).thenReturn(1);
    }

}