package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.entity.Vacancy;
import com.headkeeper.dao.VacancyDAO;
import com.headkeeper.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Repository
public class VacancyDAOImpl implements VacancyDAO {

    final
    SessionFactory sessionFactory;

    @Autowired
    public VacancyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void replaceVacancyData(Vacancy oldVacancy, Vacancy newVacancy) throws DAOException {
        oldVacancy.setEmail(newVacancy.getEmail());
        oldVacancy.setAdditionalInfoAboutSalary(newVacancy.getAdditionalInfoAboutSalary());
        oldVacancy.setDescription(newVacancy.getDescription());
        oldVacancy.setEssentialSkills(newVacancy.getEssentialSkills());
        oldVacancy.setJobType(newVacancy.getJobType());
        oldVacancy.setMinSalary(newVacancy.getMinSalary());
        oldVacancy.setMaxSalary(newVacancy.getMaxSalary());
        oldVacancy.setPhoneNumber(newVacancy.getPhoneNumber());
        oldVacancy.setTitle(newVacancy.getTitle());
        oldVacancy.setPreferableSkills(newVacancy.getPreferableSkills());
        oldVacancy.setSkills(newVacancy.getSkills());
    }

    /* CRUD OPERATIONS  */

    //------------------------------------ CREATE ---------------------------------------------
    public void addVacancy(Vacancy vacancy, int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            User user = session.get(User.class, id);
            vacancy.setUser(user);
            session.save(vacancy);
        }
        catch (HibernateException exception) {
            throw new DAOException("User with id = " + id + " is already exist");
        }
    }

    //------------------------------------ UPDATE ---------------------------------------------
    public void updateVacancy(int id, Vacancy vacancy) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Vacancy oldVacancy = session.load(Vacancy.class, id);
            replaceVacancyData(oldVacancy, vacancy);
            session.update(oldVacancy);
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + id);
        }
    }

    public void updateVacancy(int id, boolean status) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Vacancy oldVacancy = session.load(Vacancy.class, id);
            oldVacancy.setIsActive(status);
            session.update(oldVacancy);
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + id);
        }
    }

    // ------------------------------------ READ ---------------------------------------------
    public Vacancy getVacancyById(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Vacancy vacancy = session.get(Vacancy.class, id);
            return vacancy;
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + id);
        }
    }

    public Collection<Vacancy> getAllVacancies() throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<Vacancy> vacancyList = (List<Vacancy>) session.createQuery("from Vacancy").list();
            return vacancyList;
        }
        catch (HibernateException exception) {
            throw new DAOException("Error in HQL query execution.");
        }
    }

    public Collection<Vacancy> getVacanciesByStatus(boolean status) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<Vacancy> vacancies = (List<Vacancy>) session.createQuery(
                    "from Vacancy vacancy where vacancy.isActive = " + status
            ).list();
            return vacancies;
        }
        catch (HibernateException exception) {
            throw new DAOException("Error in HQL query execution.");
        }
    }

    public Collection<Vacancy> getVacanciesById(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<Vacancy> vacancies = (List<Vacancy>) session.createQuery(
                    "from Vacancy vacancy where vacancy.user.id = " + id
            ).list();
            return vacancies;
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + id);
        }
    }

    // ------------------------------------ DELETE ---------------------------------------------
    public void deleteVacancy(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            Vacancy vacancy = session.load(Vacancy.class, id);
            session.delete(vacancy);
        }
        catch (HibernateException exception) {
            throw new DAOException("Can't find user with id = " + id);
        }
    }
}
