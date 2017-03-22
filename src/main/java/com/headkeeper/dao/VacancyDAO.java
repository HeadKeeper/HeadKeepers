package com.headkeeper.dao;

import com.headkeeper.bean.Vacancy;

import java.util.Collection;

/**
 * Created by User on 22.03.2017.
 */

public interface VacancyDAO {
    /* CRUD operations */
    // CREATE
    void addVacancy(Vacancy vacancy, int id); // id - is employer's id, who added vacancy

    // UPDATE
    void updateVacancy(Vacancy vacancy);
    void updateVacancy(Vacancy vacancy, boolean status);

    // READ
    Vacancy getVacancyById(int id);
    Collection<Vacancy> getAllVacancies();
    Collection<Vacancy> getVacanciesByActivity();

    // DELETE
    void deleteVacancy(int id);
}
