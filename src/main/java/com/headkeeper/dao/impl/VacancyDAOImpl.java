package com.headkeeper.dao.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.entity.Vacancy;
import com.headkeeper.dao.VacancyDAO;
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

    @Autowired
    SessionFactory sessionFactory;

    private void replaceVacancyData(Vacancy oldVacancy, Vacancy newVacancy) {
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
    public void addVacancy(Vacancy vacancy, int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        vacancy.setUserByUserId(user);
        session.save(vacancy);
    }

    //------------------------------------ UPDATE ---------------------------------------------
    public void updateVacancy(int id, Vacancy vacancy) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy oldVacancy = session.load(Vacancy.class, id);
        replaceVacancyData(oldVacancy,vacancy);
        session.update(oldVacancy);
    }

    public void updateVacancy(int id, boolean status) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy oldVacancy = session.load(Vacancy.class, id);
        oldVacancy.setIsActive(status);
        session.update(oldVacancy);
    }

    // ------------------------------------ READ ---------------------------------------------
    public Vacancy getVacancyById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy vacancy = session.get(Vacancy.class, id);
        return vacancy;
    }

    public Collection<Vacancy> getAllVacancies() {
        Session session = sessionFactory.getCurrentSession();
        List<Vacancy> vacancyList = (List<Vacancy>) session.createQuery("from Vacancy").list();
        return vacancyList;
    }

    public Collection<Vacancy> getVacanciesByStatus(boolean status) {
        Session session = sessionFactory.getCurrentSession();
        List<Vacancy> vacancies = (List<Vacancy>) session.createQuery(
                "from Vacancy vacancy where vacancy.isActive = " + status
        ).list();
        return vacancies;
    }

    public Collection<Vacancy> getVacanciesById(int id) {
        Session session = sessionFactory.getCurrentSession();
        List<Vacancy> vacancies = (List<Vacancy>) session.createQuery(
                "from Vacancy vacancy where vacancy.userByUserId.id = " + id
        ).list();
        return vacancies;
    }

    // ------------------------------------ DELETE ---------------------------------------------
    public void deleteVacancy(int id) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy vacancy = session.load(Vacancy.class, id);
        session.delete(vacancy);
    }
}
