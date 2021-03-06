package com.headkeeper.bean.view;

import java.sql.Date;

public class ResumeAdditionalEducationView {
    private int id;
    private String type;
    private String institutionName;
    private String name;
    private Date startDate;
    private Date finishDate;
    private UserResumeView userResume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public UserResumeView getUserResume() {
        return userResume;
    }

    public void setUserResume(UserResumeView userResume) {
        this.userResume = userResume;
    }
}