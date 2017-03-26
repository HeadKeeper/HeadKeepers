package com.headkeeper.bean.base;

import java.sql.Date;

public abstract class UserResumeBase {
    protected int id;
    protected int userId;
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Date birthdayDate;
    protected String address;
    protected String martialStatus;
    protected String references;
    protected String additionalInformation;
    protected byte isActive;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract int getUserId();

    public abstract void setUserId(int userId);

    public abstract String getFirstName();

    public abstract void setFirstName(String firstName);

    public abstract String getLastName();

    public abstract void setLastName(String lastName);

    public abstract String getMiddleName();

    public abstract void setMiddleName(String middleName);

    public abstract Date getBirthdayDate();

    public abstract void setBirthdayDate(Date birthdayDate);

    public abstract String getAddress();

    public abstract void setAddress(String address);

    public abstract String getMartialStatus();

    public abstract void setMartialStatus(String martialStatus);

    public abstract String getReferences();

    public abstract void setReferences(String references);

    public abstract String getAdditionalInformation();

    public abstract void setAdditionalInformation(String additionalInformation);

    public abstract byte getIsActive();

    public abstract void setIsActive(byte isActive);
}