package com.headkeeper.bean.view;

import java.io.Serializable;

public class UserCertificateView implements Serializable {
    private int id;
    private String certificateHref;
    private String realName;

    private UserView user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCertificateHref() {
        return certificateHref;
    }

    public void setCertificateHref(String certificateHref) {
        this.certificateHref = certificateHref;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }
}