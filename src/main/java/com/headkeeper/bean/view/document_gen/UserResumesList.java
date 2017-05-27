package com.headkeeper.bean.view.document_gen;


import com.headkeeper.bean.view.document_gen.ShortUserResumeView;

import java.util.ArrayList;

public class UserResumesList {

    private ArrayList<ShortUserResumeView> resumes = new ArrayList<>(0);

    public ArrayList<ShortUserResumeView> getResumes() {
        return resumes;
    }

    public void setResumes(ArrayList<ShortUserResumeView> resumes) {
        this.resumes = resumes;
    }
}
