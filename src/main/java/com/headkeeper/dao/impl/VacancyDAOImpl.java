package com.headkeeper.dao.impl;

import com.headkeeper.bean.User;
import com.headkeeper.bean.Vacancy;
import com.headkeeper.dao.VacancyDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by User on 22.03.2017.
 */

@Transactional
@Repository
public class VacancyDAOImpl implements VacancyDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void addVacancy(Vacancy vacancy, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        vacancy.setUserByUserId(user);
        session.save(vacancy);
    }

    public void updateVacancy(Vacancy vacancy) {
        Session session = sessionFactory.getCurrentSession();

    }

    public void updateVacancy(Vacancy vacancy, boolean status) {

    }

    public void updateVacancy(Vacancy vacancy,int id) {
        Session session = sessionFactory.getCurrentSession();

    }

    public Vacancy getVacancyById(int id) {
        return null;
    }

    public Collection<Vacancy> getAllVacancies() {
        return null;
    }

    public Collection<Vacancy> getVacanciesByActivity() {
        return null;
    }

    public void deleteVacancy(int id) {

    }
}
