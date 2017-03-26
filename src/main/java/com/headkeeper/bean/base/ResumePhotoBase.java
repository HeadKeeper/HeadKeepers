package com.headkeeper.bean.base;

public abstract class ResumePhotoBase {
    protected int id;
    protected String photoHref;
    protected String realName;
    protected int userResumeId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getPhotoHref();

    public abstract void setPhotoHref(String photoHref);

    public abstract String getRealName();

    public abstract void setRealName(String realName);

    public abstract int getUserResumeId();

    public abstract void setUserResumeId(int userResumeId);
}