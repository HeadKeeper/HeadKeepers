package com.headkeeper.bean.view;

import java.io.Serializable;
import java.util.List;

public class SkillView implements Serializable {
    private int id;
    private String name;
    private byte level;
    private List<UserView> users;
    private List<VacancyView> vacancies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public List<UserView> getUsers() {
        return users;
    }

    public void setUsers(List<UserView> users) {
        this.users = users;
    }

    public List<VacancyView> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<VacancyView> vacancies) {
        this.vacancies = vacancies;
    }
}