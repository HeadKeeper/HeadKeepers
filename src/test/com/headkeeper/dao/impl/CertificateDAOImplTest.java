package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.entity.UserCertificate;
import com.headkeeper.dao.exception.DAOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CertificateDAOImplTest {

    @InjectMocks
    private CertificateDAOImpl certificateDAO;

    @Mock
    private SessionFactory sessionFactory;

    private Session session;
    private Query query;
    private User user;
    private UserCertificate certificate;

    @Before
    public void setUp() throws Exception {
        session = mock(Session.class);
        query = mock(Query.class);
        user = mock(User.class);
        certificate = mock(UserCertificate.class);
    }

    @Test
    public void addCertificate() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.get(eq(User.class), anyInt())).thenReturn(user);
        certificateDAO.addCertificate(1, new UserCertificate());

        verifyThatSessionSaveWasCalled();
        verifyThatGetCurrentSessionWasCalled();
    }

    @Test
    public void getCertificatesForUser() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.get(eq(User.class), anyInt())).thenReturn(user);
        givenCertificateDAOReturnsListOfCertificate();
    }

    @Test
    public void deleteCertificate() throws Exception {
        givenSessionFactoryReturnsCurrentSession();

        when(session.get(eq(UserCertificate.class), anyInt())).thenReturn(certificate);
        certificateDAO.deleteCertificate(1);

        verifyThatGetCurrentSessionWasCalled();
        verify(session, times(1)).delete(any());
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

    private void givenCertificateDAOReturnsListOfCertificate() throws DAOException {
        when(query.list()).thenReturn(Collections.emptyList());
    }

}