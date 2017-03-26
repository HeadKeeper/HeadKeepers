package com.headkeeper.bean.base;

public abstract class ResumeAchievementBase {
    protected int id;
    protected String name;
    protected String value;
    protected int userResumeId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getValue();

    public abstract void setValue(String value);

    public abstract int getUserResumeId();

    public abstract void setUserResumeId(int userResumeId);
}