package com.headkeeper.bean.base;

import java.io.Serializable;

public abstract class CompanyInfoBase implements Serializable {
    protected int id;
    protected String name;
    protected String description;
    protected String address;
    protected int userId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract String getAddress();

    public abstract void setAddress(String address);

    public abstract int getUserId();

    public abstract void setUserId(int userId);
}