package com.headkeeper.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "resume_work_experience", schema = "head_keepers", catalog = "")
public class ResumeWorkExperience {
    private int id;
    private String companyName;
    private String position;
    private String duties;
    private Date dateStart;
    private Date dateFinish;
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
    @Column(name = "company_name", nullable = false, length = 135)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "position", nullable = false, length = 135)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "duties", nullable = true, length = -1)
    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    @Basic
    @Column(name = "date_start", nullable = false)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "date_finish", nullable = false)
    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
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

        ResumeWorkExperience that = (ResumeWorkExperience) o;

        if (id != that.id) return false;
        if (userResumeId != that.userResumeId) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (duties != null ? !duties.equals(that.duties) : that.duties != null) return false;
        if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null) return false;
        if (dateFinish != null ? !dateFinish.equals(that.dateFinish) : that.dateFinish != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (duties != null ? duties.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateFinish != null ? dateFinish.hashCode() : 0);
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
