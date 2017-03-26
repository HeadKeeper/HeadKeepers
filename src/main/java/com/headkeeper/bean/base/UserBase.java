package com.headkeeper.bean.base;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class UserBase implements Serializable {
    protected int id;
    protected String email;
    protected String password;
    protected String nickname;
    protected boolean isActive;
    protected Timestamp creationDate;

    public abstract int getId();

    public abstract void setId(int id);

    public abstract String getEmail();

    public abstract void setEmail(String email);

    public abstract String getPassword();

    public abstract void setPassword(String password);

    public abstract String getNickname();

    public abstract void setNickname(String nickname);

    public abstract boolean getIsActive();

    public abstract void setIsActive(boolean active);

    public abstract Timestamp getCreationDate();

    public abstract void setCreationDate(Timestamp creationDate);
}