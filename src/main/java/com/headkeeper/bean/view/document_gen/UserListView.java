package com.headkeeper.bean.view.document_gen;

import com.headkeeper.bean.view.document_gen.ShortUserInformationView;

import java.util.ArrayList;

public class UserListView {
    private ArrayList<ShortUserInformationView> users = new ArrayList<>(0);

    public ArrayList<ShortUserInformationView> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<ShortUserInformationView> users) {
        this.users = users;
    }
}
