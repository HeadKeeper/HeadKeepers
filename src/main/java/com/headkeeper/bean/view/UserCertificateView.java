package com.headkeeper.bean.view;

import com.headkeeper.bean.base.UserCertificateBase;

public class UserCertificateView extends UserCertificateBase {

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
