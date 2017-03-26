package com.headkeeper.bean.base;

import java.io.Serializable;

public abstract class SkillBase implements Serializable {
    protected int id;
    protected String name;
    protected byte level;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract byte getLevel();

    public abstract void setLevel(byte level);
}