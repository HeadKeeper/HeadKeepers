package com.headkeeper.bean.entity;

import com.headkeeper.bean.base.UserResumeBase;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "user_resume", schema = "head_keepers", catalog = "")
public class UserResume extends UserResumeBase {

    private Set<EmployerToResume> employerToResumes;
    private Set<ResumeAchievement> resumeAchievements;
    private Set<ResumeAdditionalEducation> resumeAdditionalEducations;
    private Set<ResumeContactInfo> resumeContactInfos;
    private Set<ResumeEducation> resumeEducations;
    private Set<ResumeLanguage> resumeLanguages;
    private Set<ResumePhoto> resumePhotos;
    private Set<ResumeToVacancy> resumeToVacancies;
    private Set<ResumeWorkExperience> resumeWorkExperiences;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "middle_name", nullable = false, length = 45)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "birthday_date", nullable = false)
    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "martial_status", nullable = false, length = 12)
    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    @Basic
    @Column(name = "references", nullable = true, length = -1)
    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    @Basic
    @Column(name = "additional_information", nullable = true, length = -1)
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResume that = (UserResume) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (isActive != that.isActive) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (birthdayDate != null ? !birthdayDate.equals(that.birthdayDate) : that.birthdayDate != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (martialStatus != null ? !martialStatus.equals(that.martialStatus) : that.martialStatus != null)
            return false;
        if (references != null ? !references.equals(that.references) : that.references != null) return false;
        if (additionalInformation != null ? !additionalInformation.equals(that.additionalInformation) : that.additionalInformation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (birthdayDate != null ? birthdayDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (martialStatus != null ? martialStatus.hashCode() : 0);
        result = 31 * result + (references != null ? references.hashCode() : 0);
        result = 31 * result + (additionalInformation != null ? additionalInformation.hashCode() : 0);
        result = 31 * result + (int) isActive;
        return result;
    }

    @OneToMany(mappedBy = "userResume")
    public Set<EmployerToResume> getEmployerToResumes() {
        return employerToResumes;
    }

    public void setEmployerToResumes(Set<EmployerToResume> employerToResumes) {
        this.employerToResumes = employerToResumes;
    }

    @OneToMany(mappedBy = "userResume")
    public Set<ResumeAchievement> getResumeAchievements() {
        return resumeAchievements;
    }

    public void setResumeAchievements(Set<ResumeAchievement> resumeAchievements) {
        this.resumeAchievements = resumeAchievements;
    }

    @OneToMany(mappedBy = "userResume")
    public Set<ResumeAdditionalEducation> getResumeAdditionalEducations() {
        return resumeAdditionalEducations;
    }

    public void setResumeAdditionalEducations(Set<ResumeAdditionalEducation> resumeAdditionalEducations) {
        this.resumeAdditionalEducations = resumeAdditionalEducations;
    }

    @OneToMany(mappedBy = "userResumeByUserResumeId")
    public Set<ResumeContactInfo> getResumeContactInfos() {
        return resumeContactInfos;
    }

    public void setResumeContactInfos(Set<ResumeContactInfo> resumeContactInfos) {
        this.resumeContactInfos = resumeContactInfos;
    }

    @OneToMany(mappedBy = "userResume")
    public Set<ResumeEducation> getResumeEducations() {
        return resumeEducations;
    }

    public void setResumeEducations(Set<ResumeEducation> resumeEducations) {
        this.resumeEducations = resumeEducations;
    }

    @OneToMany(mappedBy = "userResume")
    public Set<ResumeLanguage> getResumeLanguages() {
        return resumeLanguages;
    }

    public void setResumeLanguages(Set<ResumeLanguage> resumeLanguages) {
        this.resumeLanguages = resumeLanguages;
    }

    @OneToMany(mappedBy = "userResume")
    public Set<ResumePhoto> getResumePhotos() {
        return resumePhotos;
    }

    public void setResumePhotos(Set<ResumePhoto> resumePhotos) {
        this.resumePhotos = resumePhotos;
    }

    @OneToMany(mappedBy = "userResume")
    public Set<ResumeToVacancy> getResumeToVacancies() {
        return resumeToVacancies;
    }

    public void setResumeToVacancies(Set<ResumeToVacancy> resumeToVacancies) {
        this.resumeToVacancies = resumeToVacancies;
    }

    @OneToMany(mappedBy = "userResumeByUserResumeId")
    public Set<ResumeWorkExperience> getResumeWorkExperiences() {
        return resumeWorkExperiences;
    }

    public void setResumeWorkExperiences(Set<ResumeWorkExperience> resumeWorkExperiences) {
        this.resumeWorkExperiences = resumeWorkExperiences;
    }
}