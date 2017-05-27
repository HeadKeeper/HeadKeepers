package com.headkeeper.bean.view;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class UserResumeView implements Serializable {
    private int id;
    private int userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthdayDate;
    private String address;
    private String martialStatus;
    private String references;
    private String additionalInformation;
    private boolean active;

    private List<ResumeAchievementView> resumeAchievements;
    private List<ResumeAdditionalEducationView> resumeAdditionalEducations;
    private List<ResumeContactInfoView> resumeContactInfos;
    private List<ResumeEducationView> resumeEducations;
    private List<ResumeLanguageView> resumeLanguages;
    private List<ResumePhotoView> resumePhotos;
    private List<ResumeWorkExperienceView> resumeWorkExperiences;

    private List<UserView> employers;
    private List<UserResumeView> resumes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ResumeAchievementView> getResumeAchievements() {
        return resumeAchievements;
    }

    public void setResumeAchievements(List<ResumeAchievementView> resumeAchievements) {
        this.resumeAchievements = resumeAchievements;
    }

    public List<ResumeAdditionalEducationView> getResumeAdditionalEducations() {
        return resumeAdditionalEducations;
    }

    public void setResumeAdditionalEducations(List<ResumeAdditionalEducationView> resumeAdditionalEducations) {
        this.resumeAdditionalEducations = resumeAdditionalEducations;
    }

    public List<ResumeContactInfoView> getResumeContactInfos() {
        return resumeContactInfos;
    }

    public void setResumeContactInfos(List<ResumeContactInfoView> resumeContactInfos) {
        this.resumeContactInfos = resumeContactInfos;
    }

    public List<ResumeEducationView> getResumeEducations() {
        return resumeEducations;
    }

    public void setResumeEducations(List<ResumeEducationView> resumeEducations) {
        this.resumeEducations = resumeEducations;
    }

    public List<ResumeLanguageView> getResumeLanguages() {
        return resumeLanguages;
    }

    public void setResumeLanguages(List<ResumeLanguageView> resumeLanguages) {
        this.resumeLanguages = resumeLanguages;
    }

    public List<ResumePhotoView> getResumePhotos() {
        return resumePhotos;
    }

    public void setResumePhotos(List<ResumePhotoView> resumePhotos) {
        this.resumePhotos = resumePhotos;
    }

    public List<ResumeWorkExperienceView> getResumeWorkExperiences() {
        return resumeWorkExperiences;
    }

    public void setResumeWorkExperiences(List<ResumeWorkExperienceView> resumeWorkExperiences) {
        this.resumeWorkExperiences = resumeWorkExperiences;
    }

    public List<UserView> getEmployers() {
        return employers;
    }

    public void setEmployers(List<UserView> employers) {
        this.employers = employers;
    }

    public List<UserResumeView> getResumes() {
        return resumes;
    }

    public void setResumes(List<UserResumeView> resumes) {
        this.resumes = resumes;
    }
}