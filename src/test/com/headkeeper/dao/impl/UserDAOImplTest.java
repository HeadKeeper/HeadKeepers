package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.CompanyInfo;
import com.headkeeper.bean.entity.EmployerInfo;
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

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserDAOImplTest {

    @InjectMocks
    private UserDAOImpl userDAO;

    @Mock
    private SessionFactory sessionFactory;

    private Session session;
    private Query query;
    private User user;
    private CompanyInfo companyInfo;
    private EmployerInfo employerInfo;
    private List list;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        query = mock(Query.class);
        user = mock(User.class);
        companyInfo = mock(CompanyInfo.class);
        employerInfo = mock(EmployerInfo.class);
        list = mock(List.class);
    }

    @Test
    public void addNewUser() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        userDAO.addNewUser(new User(), 1);

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addCompanyInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        userDAO.addCompanyInfo(new CompanyInfo(), 1);

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void addEmployerInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        userDAO.addEmployerInfo(new EmployerInfo(), 1);

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getUserById() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsUser();
        User user = userDAO.getUserById(1);
        Assert.assertNotNull(user);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getCompanyInfoById() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsCompanyInfo();
        CompanyInfo info = userDAO.getCompanyInfoById(1);
        Assert.assertNotNull(info);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getEmployerInfoById() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsEmployerInfo();
        EmployerInfo info = userDAO.getEmployerInfoById(1);
        Assert.assertNotNull(info);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getUsers() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        List list = userDAO.getUsers();
        Assert.assertNotNull(list);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getUserByEmail() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        when(query.getSingleResult()).thenReturn(user);
        User emailUser = userDAO.getUserByEmail("a");
        Assert.assertNotNull(emailUser);

        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateUser() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        userDAO.updateUser(1, new User());

        verifyThatSessionMergeWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateCompanyInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsCompanyInfo();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        userDAO.updateCompanyInfo(1, new CompanyInfo());

        verifyThatSessionMergeWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void updateEmployerInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        givenSessionReturnsEmployerInfo();
        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        userDAO.updateEmployerInfo(1, new EmployerInfo());

        verifyThatSessionMergeWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteUser() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        userDAO.deleteUser(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteCompanyInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        userDAO.deleteCompanyInfo(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void deleteEmployerInfo() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.createQuery(anyString())).thenReturn(query);
        givenSessionFactoryReturnsNotEmptyList();
        userDAO.deleteEmployerInfo(1);

        verifyThatSessionDeleteWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    private void givenSessionReturnsUser() {
        when(session.get(eq(User.class), anyInt())).thenReturn(user);
    }

    private void givenSessionReturnsCompanyInfo() {
        when(session.get(eq(CompanyInfo.class), anyInt())).thenReturn(companyInfo);
    }

    private void givenSessionReturnsEmployerInfo() {
        when(session.get(eq(EmployerInfo.class), anyInt())).thenReturn(employerInfo);
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

    private void givenSessionFactoryReturnsNotEmptyList() {
        when(session.createQuery(anyString()).list()).thenReturn(list);
        when(list.size()).thenReturn(1);
    }

}