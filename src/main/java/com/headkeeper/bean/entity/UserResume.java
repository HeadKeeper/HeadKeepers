package com.headkeeper.bean.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_resume", schema = "head_keepers")
public class UserResume {

    private int id;
    private User user;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthdayDate;
    private String address;
    private String martialStatus;
    private String references;
    private String additionalInformation;
    private boolean isActive;
    private Set<EmployerToResume> employerToResumes = new HashSet<>();
    private Set<ResumeAchievement> resumeAchievements = new HashSet<>();
    private Set<ResumeAdditionalEducation> resumeAdditionalEducations = new HashSet<>();
    private Set<ResumeContactInfo> resumeContactInfos = new HashSet<>();
    private Set<ResumeEducation> resumeEducations = new HashSet<>();
    private Set<ResumeLanguage> resumeLanguages = new HashSet<>();
    private Set<ResumePhoto> resumePhotos = new HashSet<>();
    private Set<ResumeToVacancy> resumeToVacancies = new HashSet<>();
    private Set<ResumeWorkExperience> resumeWorkExperiences = new HashSet<>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "user_references", length = 255)
    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    @Basic
    @Column(name = "additional_information", length = 255)
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResume that = (UserResume) o;

        if (id != that.id) return false;
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
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (birthdayDate != null ? birthdayDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (martialStatus != null ? martialStatus.hashCode() : 0);
        result = 31 * result + (references != null ? references.hashCode() : 0);
        result = 31 * result + (additionalInformation != null ? additionalInformation.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}