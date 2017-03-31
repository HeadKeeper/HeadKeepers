package com.headkeeper.bean.view;

public class ResumeContactInfoView {
    private int id;
    private String type;
    private String value;
    private UserResumeView userResume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserResumeView getUserResume() {
        return userResume;
    }

    public void setUserResume(UserResumeView userResume) {
        this.userResume = userResume;
    }
}