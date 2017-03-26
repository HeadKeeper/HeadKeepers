package com.headkeeper.bean.view;

import com.headkeeper.bean.base.VacancyBase;

import java.math.BigDecimal;

public class VacancyView extends VacancyBase {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEssentialSkills() {
        return essentialSkills;
    }

    public void setEssentialSkills(String essentialSkills) {
        this.essentialSkills = essentialSkills;
    }

    public String getPreferableSkills() {
        return preferableSkills;
    }

    public void setPreferableSkills(String preferableSkills) {
        this.preferableSkills = preferableSkills;
    }

    public byte getJobType() {
        return jobType;
    }

    public void setJobType(byte jobType) {
        this.jobType = jobType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getAdditionalInfoAboutSalary() {
        return additionalInfoAboutSalary;
    }

    public void setAdditionalInfoAboutSalary(String additionalInfoAboutSalary) {
        this.additionalInfoAboutSalary = additionalInfoAboutSalary;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }
}
