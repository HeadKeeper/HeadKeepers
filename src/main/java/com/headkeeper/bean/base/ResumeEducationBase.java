package com.headkeeper.bean.base;

import java.sql.Date;

public abstract class ResumeEducationBase {
    protected int id;
    protected String institutionName;
    protected String type;
    protected String facultyName;
    protected Date startDate;
    protected Date finishDate;
    protected String additionalInformation;
    protected int userResumeId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getInstitutionName();

    public abstract void setInstitutionName(String institutionName);

    public abstract String getType();

    public abstract void setType(String type);

    public abstract String getFacultyName();

    public abstract void setFacultyName(String facultyName);

    public abstract Date getStartDate();

    public abstract void setStartDate(Date startDate);

    public abstract Date getFinishDate();

    public abstract void setFinishDate(Date finishDate);

    public abstract String getAdditionalInformation();

    public abstract void setAdditionalInformation(String additionalInformation);

    public abstract int getUserResumeId();

    public abstract void setUserResumeId(int userResumeId);
}