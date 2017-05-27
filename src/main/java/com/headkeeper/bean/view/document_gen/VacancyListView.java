package com.headkeeper.bean.view.document_gen;

import com.headkeeper.bean.view.document_gen.ShortVacancyView;

import java.util.ArrayList;

public class VacancyListView {

    private ArrayList<ShortVacancyView> vacancies = new ArrayList<>();

    public ArrayList<ShortVacancyView> getVacancies() {
        return vacancies;
    }

    public void setVacancies(ArrayList<ShortVacancyView> vacancies) {
        this.vacancies = vacancies;
    }
}
