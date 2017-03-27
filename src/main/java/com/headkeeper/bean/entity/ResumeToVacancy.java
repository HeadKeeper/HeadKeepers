package com.headkeeper.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "resume_to_vacancy", schema = "head_keepers", catalog = "")
@IdClass(ResumeToVacancyPK.class)
public class ResumeToVacancy {

    private Timestamp requestTime;
    private byte isClosed;
    private String message;
    private int vacancyId;
    private int userResumeId;
    private Vacancy vacancy;
    private UserResume userResume;

    @Id
    @Column(name = "vacancy_id", nullable = false)
    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    @Id
    @Column(name = "user_resume_id", nullable = false)
    public int getUserResumeId() {
        return userResumeId;
    }

    public void setUserResumeId(int userResumeId) {
        this.userResumeId = userResumeId;
    }

    @Basic
    @Column(name = "request_time", nullable = false)
    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    @Basic
    @Column(name = "is_closed", nullable = false)
    public byte getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(byte isClosed) {
        this.isClosed = isClosed;
    }

    @Basic
    @Column(name = "message", nullable = true, length = 255)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResumeToVacancy that = (ResumeToVacancy) o;

        if (isClosed != that.isClosed) return false;
        if (requestTime != null ? !requestTime.equals(that.requestTime) : that.requestTime != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestTime != null ? requestTime.hashCode() : 0;
        result = 31 * result + (int) isClosed;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "vacancy_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Vacancy getVacancy() {
        return vacancy;
    }

    public void setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }

    @ManyToOne
    @JoinColumn(name = "user_resume_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public UserResume getUserResume() {
        return userResume;
    }

    public void setUserResume(UserResume userResume) {
        this.userResume = userResume;
    }
}