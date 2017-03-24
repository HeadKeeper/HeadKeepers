package com.headkeeper.dao;

import com.headkeeper.bean.Vacancy;
import sun.text.resources.el.CollationData_el;

import java.util.Collection;

public interface VacancyDAO {
    /* CRUD operations */
    // CREATE
    void addVacancy(Vacancy vacancy, int id); // id - is employer's id, who added vacancy

    // UPDATE
    void updateVacancy(int id, Vacancy vacancy);
    void updateVacancy(int id, boolean status);

    // READ
    Vacancy getVacancyById(int id);
    Collection<Vacancy> getAllVacancies();
    Collection<Vacancy> getVacanciesByStatus(boolean status);
    Collection<Vacancy> getVacanciesById(int id);

    // DELETE
    void deleteVacancy(int id);
}
