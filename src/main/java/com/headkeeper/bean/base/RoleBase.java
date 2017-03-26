package com.headkeeper.bean.base;

import java.io.Serializable;

public abstract class RoleBase implements Serializable {
    protected int id;
    protected String value;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getValue();

    public abstract void setValue(String value);
}