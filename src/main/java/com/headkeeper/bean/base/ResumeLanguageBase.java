package com.headkeeper.bean.base;

public abstract class ResumeLanguageBase {
    protected int id;
    protected String language;
    protected String level;
    protected int userResumeId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getLanguage();

    public abstract void setLanguage(String language);

    public abstract String getLevel();

    public abstract void setLevel(String level);

    public abstract int getUserResumeId();

    public abstract void setUserResumeId(int userResumeId);
}