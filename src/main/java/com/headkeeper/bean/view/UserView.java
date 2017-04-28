package com.headkeeper.bean.view;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class UserView implements Serializable {
    private int id;
    private String email;
    private String password;
    private String nickname;
    private boolean isActive;
    private Timestamp creationDate;

    private List<SkillView> skills;
    private RoleView role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public List<SkillView> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillView> skills) {
        this.skills = skills;
    }

    public RoleView getRole() {
        return role;
    }

    public void setRole(RoleView role) {
        this.role = role;
    }
}