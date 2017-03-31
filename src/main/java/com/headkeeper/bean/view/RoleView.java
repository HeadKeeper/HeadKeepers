package com.headkeeper.bean.view;

import java.io.Serializable;
import java.util.List;

public class RoleView implements Serializable {
    protected int id;
    protected String value;

    private List<UserView> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<UserView> getUsers() {
        return users;
    }

    public void setUsers(List<UserView> users) {
        this.users = users;
    }
}