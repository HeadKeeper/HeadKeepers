package com.headkeeper.bean.view;

import java.math.BigDecimal;
import java.util.List;

public class VacancyView {
    private int id;
    private String title;
    private String description;
    private String essentialSkills;
    private String preferableSkills;
    private String phoneNumber;
    private String email;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private String additionalInfoAboutSalary;
    private boolean isActive;

    private UserView user;
    private List<SkillView> skills;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

    public List<SkillView> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillView> skills) {
        this.skills = skills;
    }
}