package com.headkeeper.bean.view.document_gen;

import java.util.ArrayList;

public class CompanyListView {

    private ArrayList<ShortCompanyInfoView> companies = new ArrayList<>(0);

    public ArrayList<ShortCompanyInfoView> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<ShortCompanyInfoView> companies) {
        this.companies = companies;
    }
}
