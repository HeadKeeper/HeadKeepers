package com.headkeeper.bean.base;

import java.sql.Date;

public abstract class ResumeWorkExperienceBase {
    protected int id;
    protected String companyName;
    protected String position;
    protected String duties;
    protected Date dateStart;
    protected Date dateFinish;
    protected int userResumeId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getCompanyName();

    public abstract void setCompanyName(String companyName);

    public abstract String getPosition();

    public abstract void setPosition(String position);

    public abstract String getDuties();

    public abstract void setDuties(String duties);

    public abstract Date getDateStart();

    public abstract void setDateStart(Date dateStart);

    public abstract Date getDateFinish();

    public abstract void setDateFinish(Date dateFinish);

    public abstract int getUserResumeId();

    public abstract void setUserResumeId(int userResumeId);
}
