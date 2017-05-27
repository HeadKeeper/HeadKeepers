package com.headkeeper.bean.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_certificate", schema = "head_keepers")
public class UserCertificate {

    private int id;
    private String certificateHref;
    private String realName;
    private User user;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "certificate_href", nullable = false, length = 255)
    public String getCertificateHref() {
        return certificateHref;
    }

    public void setCertificateHref(String certificateHref) {
        this.certificateHref = certificateHref;
    }

    @Basic
    @Column(name = "real_name", nullable = true, length = 150)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCertificate that = (UserCertificate) o;

        if (id != that.id) return false;
        if (certificateHref != null ? !certificateHref.equals(that.certificateHref) : that.certificateHref != null)
            return false;
        if (realName != null ? !realName.equals(that.realName) : that.realName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (certificateHref != null ? certificateHref.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        return result;
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