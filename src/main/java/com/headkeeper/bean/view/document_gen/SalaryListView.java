package com.headkeeper.bean.view.document_gen;

import java.util.ArrayList;

public class SalaryListView {

    private ArrayList<ShortSalaryView> salaries = new ArrayList<>();

    public ArrayList<ShortSalaryView> getSalaries() {
        return salaries;
    }

    public void setSalaries(ArrayList<ShortSalaryView> salaries) {
        this.salaries = salaries;
    }
}
