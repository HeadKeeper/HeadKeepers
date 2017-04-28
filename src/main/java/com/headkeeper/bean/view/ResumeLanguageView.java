package com.headkeeper.bean.view;

public class ResumeLanguageView {
    private int id;
    private String language;
    private String level;
    private UserResumeView userResume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public UserResumeView getUserResume() {
        return userResume;
    }

    public void setUserResume(UserResumeView userResume) {
        this.userResume = userResume;
    }
}