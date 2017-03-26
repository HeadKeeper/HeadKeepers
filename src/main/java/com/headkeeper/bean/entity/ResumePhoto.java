package com.headkeeper.bean.entity;

import com.headkeeper.bean.base.ResumePhotoBase;

import javax.persistence.*;

@Entity
@Table(name = "resume_photo", schema = "head_keepers", catalog = "")
public class ResumePhoto extends ResumePhotoBase {

    private UserResume userResume;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "photo_href", nullable = false, length = 100)
    public String getPhotoHref() {
        return photoHref;
    }

    public void setPhotoHref(String photoHref) {
        this.photoHref = photoHref;
    }

    @Basic
    @Column(name = "real_name", nullable = false, length = 150)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

        ResumePhoto that = (ResumePhoto) o;

        if (id != that.id) return false;
        if (userResumeId != that.userResumeId) return false;
        if (photoHref != null ? !photoHref.equals(that.photoHref) : that.photoHref != null) return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (photoHref != null ? photoHref.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + userResumeId;
        return result;
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