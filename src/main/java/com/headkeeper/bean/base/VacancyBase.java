package com.headkeeper.bean.base;

import java.math.BigDecimal;

public abstract class VacancyBase {
    protected int id;
    protected String title;
    protected String description;
    protected String essentialSkills;
    protected String preferableSkills;
    protected byte jobType;
    protected String phoneNumber;
    protected String email;
    protected BigDecimal minSalary;
    protected BigDecimal maxSalary;
    protected String additionalInfoAboutSalary;
    protected boolean isActive;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getTitle();

    public abstract void setTitle(String title);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract String getEssentialSkills();

    public abstract void setEssentialSkills(String essentialSkills);

    public abstract String getPreferableSkills();

    public abstract void setPreferableSkills(String preferableSkills);

    public abstract byte getJobType();

    public abstract void setJobType(byte jobType);

    public abstract String getPhoneNumber();

    public abstract void setPhoneNumber(String phoneNumber);

    public abstract String getEmail();

    public abstract void setEmail(String email);

    public abstract BigDecimal getMinSalary();

    public abstract void setMinSalary(BigDecimal minSalary);

    public abstract BigDecimal getMaxSalary();

    public abstract void setMaxSalary(BigDecimal maxSalary);

    public abstract String getAdditionalInfoAboutSalary();

    public abstract void setAdditionalInfoAboutSalary(String additionalInfoAboutSalary);

    public abstract boolean getIsActive();

    public abstract void setIsActive(boolean active);
}