package com.headkeeper.dao;

import com.headkeeper.bean.entity.CompanyInfo;
import com.headkeeper.bean.entity.Vacancy;
import com.headkeeper.dao.exception.DAOException;

import java.util.Collection;
import java.util.List;

public interface VacancyDAO {
    /* CRUD operations */
    // CREATE
    void addVacancy(Vacancy vacancy, int id) throws DAOException; // id - is employer's id, who added vacancy

    // UPDATE
    void updateVacancy(int id, Vacancy vacancy) throws DAOException;
    void updateVacancy(int id, boolean status) throws DAOException;

    // READ
    Vacancy getVacancyById(int id) throws DAOException;
    Collection<Vacancy> getAllVacancies() throws DAOException;
    Collection<Vacancy> getVacanciesByStatus(boolean status) throws DAOException;
    Collection<Vacancy> getVacanciesById(int id) throws DAOException;
    List<Vacancy> getVacanciesByTitle(String title) throws DAOException;
    CompanyInfo getCompanyByCompanyName(String companyName) throws DAOException;

    // DELETE
    void deleteVacancy(int id) throws DAOException;
}
