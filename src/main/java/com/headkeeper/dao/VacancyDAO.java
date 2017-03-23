package com.headkeeper.dao;

import com.headkeeper.bean.Vacancy;

import java.util.Collection;

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
    Collection<Vacancy> getVacanciesByStatus(boolean status);

    // DELETE
    void deleteVacancy(int id);
}
