package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.EmployerToResume;
import com.headkeeper.bean.entity.ResumeToVacancy;
import com.headkeeper.bean.entity.UserResume;
import com.headkeeper.dao.UserInteractionEmployerDAO;
import com.headkeeper.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


@Transactional
@Repository
public class UserInteractionEmployerDAOImpl implements UserInteractionEmployerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserInteractionEmployerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void createEmployerRequestToResume(int employerId, int resumeId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EmployerToResume request = new EmployerToResume();
            request.setIsClosed(false);
            request.setUserId(employerId);
            request.setUserResumeId(resumeId);
            request.setRequestTime(new Timestamp(System.currentTimeMillis()));
            session.save(request);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with database resources");
        }
    }

    public void createRequestToVacancy(int resumeId, int vacancyId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeToVacancy request = new ResumeToVacancy();
            request.setRequestTime(new Timestamp(System.currentTimeMillis()));
            request.setIsClosed(false);
            request.setVacancyId(vacancyId);
            request.setUserResumeId(resumeId);
            session.save(request);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void readUserResume(int resumeId, String message) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            ResumeToVacancy reviewedResume = session.load(ResumeToVacancy.class, resumeId);
            reviewedResume.setIsClosed(true);
            reviewedResume.setMessage(message);
            session.save(reviewedResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find resume with id = " + resumeId);
        }
    }

    public void readEmployerRequest(int employerId, String message) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            EmployerToResume employerToResume = session.load(EmployerToResume.class, employerId);
            employerToResume.setIsClosed(true);
            employerToResume.setMessage(message);
            session.save(employerToResume);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't get current session.");
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find employer request with id = " + employerId);
        }
    }
}
