package com.headkeeper.bean.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "employer_to_resume", schema = "head_keepers", catalog = "")
@IdClass(EmployerToResumePK.class)
public class EmployerToResume {
    private Timestamp requestTime;
    private byte isClosed;
    private String message;
    private int userId;
    private int userResumeId;
    private User user;
    private UserResume userResume;

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

        EmployerToResume that = (EmployerToResume) o;

        if (isClosed != that.isClosed) return false;
        if (userId != that.userId) return false;
        if (userResumeId != that.userResumeId) return false;
        if (requestTime != null ? !requestTime.equals(that.requestTime) : that.requestTime != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestTime != null ? requestTime.hashCode() : 0;
        result = 31 * result + (int) isClosed;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + userResumeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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