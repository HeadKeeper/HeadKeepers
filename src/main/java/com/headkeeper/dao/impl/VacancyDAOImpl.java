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
import java.util.List;

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

    public void updateVacancy(Vacancy vacancy) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy oldVacancy = session.load(Vacancy.class, vacancy.getUserByUserId().getId());
        replaceVacancyData(oldVacancy,vacancy);
        session.update(oldVacancy);
    }

    public void updateVacancy(Vacancy vacancy, boolean status) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy oldVacancy = session.load(Vacancy.class, vacancy.getId());
        oldVacancy.setIsActive(status);
        session.update(oldVacancy);
    }

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
        List<Vacancy> vacancyList = (List<Vacancy>) session.createQuery(
                "from Vacancy vacancy where vacancy.isActive = " + status
        ).list();
        return vacancyList;
    }

    public void deleteVacancy(int id) {
        Session session = sessionFactory.getCurrentSession();
        Vacancy vacancy = session.load(Vacancy.class, id);
        session.delete(vacancy);
    }
}
