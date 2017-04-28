package com.headkeeper.bean.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class EmployerToResumePK implements Serializable {
    private int userId;
    private int userResumeId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "user_resume_id", nullable = false)
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

        EmployerToResumePK that = (EmployerToResumePK) o;

        if (userId != that.userId) return false;
        if (userResumeId != that.userResumeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + userResumeId;
        return result;
    }
}