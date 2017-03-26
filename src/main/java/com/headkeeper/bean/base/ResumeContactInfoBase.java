package com.headkeeper.bean.base;

public abstract class ResumeContactInfoBase {
    protected int id;
    protected String type;
    protected String value;
    protected int userResumeId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getType();

    public abstract void setType(String type);

    public abstract String getValue();

    public abstract void setValue(String value);

    public abstract int getUserResumeId();

    public abstract void setUserResumeId(int userResumeId);
}