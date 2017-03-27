package com.headkeeper.bean.view;

import java.io.Serializable;

public class RoleView implements Serializable {
    protected int id;
    protected String value;

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
}