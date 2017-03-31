package com.headkeeper.bean.view;

import java.sql.Date;

public class ResumeWorkExperienceView {
    private int id;
    private String companyName;
    private String position;
    private String duties;
    private Date dateStart;
    private Date dateFinish;

    private UserResumeView userResume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public UserResumeView getUserResume() {
        return userResume;
    }

    public void setUserResume(UserResumeView userResume) {
        this.userResume = userResume;
    }
}
