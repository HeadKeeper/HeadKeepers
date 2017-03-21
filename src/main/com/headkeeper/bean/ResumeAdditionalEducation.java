package com.headkeeper.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "resume_additional_education", schema = "head_keepers", catalog = "")
public class ResumeAdditionalEducation {
    private int id;
    private String type;
    private String institutionName;
    private String name;
    private Date startDate;
    private Date finishDate;
    private int userResumeId;
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
    @Column(name = "type", nullable = false, length = 45)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "institution_name", nullable = false, length = 255)
    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "finish_date", nullable = true)
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
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

        ResumeAdditionalEducation that = (ResumeAdditionalEducation) o;

        if (id != that.id) return false;
        if (userResumeId != that.userResumeId) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (institutionName != null ? !institutionName.equals(that.institutionName) : that.institutionName != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (finishDate != null ? !finishDate.equals(that.finishDate) : that.finishDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (institutionName != null ? institutionName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
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