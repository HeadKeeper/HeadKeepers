package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.entity.UserCertificate;
import com.headkeeper.dao.CertificateDAO;
import com.headkeeper.dao.exception.DAOException;
import com.headkeeper.dao.util.EntityPreprocessor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public class CertificateDAOImpl implements CertificateDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public CertificateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCertificate(int userId, UserCertificate certificate) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, userId);
            if (user == null) {
                throw new DAOException("Can't find user with id = " + userId);
            }
            certificate.setUser(user);
            session.save(certificate);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session.");
        }
    }

    public List<UserCertificate> getCertificatesForUser(int userId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EntityPreprocessor.checkEntityOnExist(User.class.getName(), userId, session);
            List<UserCertificate> certificates = session.createQuery(
                    "from UserCertificate where UserCertificate .user.id = " + userId
            ).list();
            return certificates;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user id = " + userId);
        }
    }

    public void deleteCertificate(int certificateId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            UserCertificate certificate = session.get(UserCertificate.class, session);
            if (certificate == null) {
                throw new DAOException("Can't find certificate with id = " + certificateId);
            }
            session.delete(certificate);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open new session");
        }
    }
}
