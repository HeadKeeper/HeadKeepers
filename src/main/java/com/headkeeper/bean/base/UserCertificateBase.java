package com.headkeeper.bean.base;

public abstract class UserCertificateBase {
    protected int id;
    protected String certificateHref;
    protected String realName;
    protected int userId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getCertificateHref();

    public abstract void setCertificateHref(String certificateHref);

    public abstract String getRealName();

    public abstract void setRealName(String realName);

    public abstract int getUserId();

    public abstract void setUserId(int userId);
}