package com.headkeeper.bean.view;

public class ResumePhotoView {
    private int id;
    private String photoHref;
    private String realName;

    private UserResumeView userResume;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoHref() {
        return photoHref;
    }

    public void setPhotoHref(String photoHref) {
        this.photoHref = photoHref;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public UserResumeView getUserResume() {
        return userResume;
    }

    public void setUserResume(UserResumeView userResume) {
        this.userResume = userResume;
    }
}