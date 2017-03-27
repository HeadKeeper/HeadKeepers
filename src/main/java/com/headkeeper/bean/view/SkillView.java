package com.headkeeper.bean.view;

import java.io.Serializable;

public class SkillView implements Serializable {
    private int id;
    private String name;
    private byte level;

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
}