package com.headkeeper.bean.base;

public abstract class EmployerInfoBase {
    protected int id;
    protected String name;
    protected String phoneNumber;
    protected int userId;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getPhoneNumber();

    public abstract void setPhoneNumber(String phoneNumber);

    public abstract int getUserId();

    public abstract void setUserId(int userId);
}