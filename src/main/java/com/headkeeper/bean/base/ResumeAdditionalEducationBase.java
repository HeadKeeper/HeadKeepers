package com.headkeeper.bean.base;

import java.sql.Date;

public abstract class ResumeAdditionalEducationBase {
    protected int id;
    protected String type;
    protected String institutionName;
    protected String name;
    protected Date startDate;
    protected Date finishDate;
    protected int userResumeId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getType();

    public abstract void setType(String type);

    public abstract String getInstitutionName();

    public abstract void setInstitutionName(String institutionName);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Date getStartDate();

    public abstract void setStartDate(Date startDate);

    public abstract Date getFinishDate();

    public abstract void setFinishDate(Date finishDate);

    public abstract int getUserResumeId();

    public abstract void setUserResumeId(int userResumeId);

}