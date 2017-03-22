package com.headkeeper.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ResumeToVacancyPK implements Serializable {
    private int vacancyId;
    private int userResumeId;

    @Column(name = "vacancy_id", nullable = false)
    @Id
    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    @Column(name = "user_resume_id", nullable = false)
    @Id
    public int getUserResumeId() {
        return userResumeId;
    }

    public void setUserResumeId(int userResumeId) {
        this.userResumeId = userResumeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeToVacancyPK that = (ResumeToVacancyPK) o;

        if (vacancyId != that.vacancyId) return false;
        if (userResumeId != that.userResumeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vacancyId;
        result = 31 * result + userResumeId;
        return result;
    }
}