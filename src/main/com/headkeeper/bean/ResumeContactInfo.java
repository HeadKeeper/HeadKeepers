package com.headkeeper.bean;

import javax.persistence.*;

@Entity
@Table(name = "resume_contact_info", schema = "head_keepers", catalog = "")
public class ResumeContactInfo {
    private int id;
    private String type;
    private String value;
    private int userResumeId;
    private UserResume userResumeByUserResumeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "value", nullable = false, length = 135)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
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

        ResumeContactInfo that = (ResumeContactInfo) o;

        if (id != that.id) return false;
        if (userResumeId != that.userResumeId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + userResumeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_resume_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public UserResume getUserResumeByUserResumeId() {
        return userResumeByUserResumeId;
    }

    public void setUserResumeByUserResumeId(UserResume userResumeByUserResumeId) {
        this.userResumeByUserResumeId = userResumeByUserResumeId;
    }
}