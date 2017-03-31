package com.headkeeper.service.util;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.entity.Vacancy;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.bean.view.VacancyView;

import java.util.LinkedList;
import java.util.List;

public class Exchanger {

    public static UserView exchangeEntityToView(User userEntity) {
        UserView userView = new UserView();

        userView.setId(userEntity.getId());
        userView.setEmail(userEntity.getEmail());
        userView.setPassword(userEntity.getPassword());
        userView.setNickname(userEntity.getNickname());
        userView.setCreationDate(userEntity.getCreationDate());
        userView.setActive(userEntity.getIsActive());

        return userView;
    }

    public static User exchangeViewToEntity(UserView userView) {
        User userEntity = new User();

        userEntity.setId(userView.getId());
        userEntity.setEmail(userView.getEmail());
        userEntity.setPassword(userView.getPassword());
        userEntity.setNickname(userView.getNickname());
        userEntity.setCreationDate(userView.getCreationDate());
        userEntity.setIsActive(userView.isActive());

        return userEntity;
    }

    public static Vacancy exchangeViewToEntity(VacancyView vacancyView) {
        Vacancy vacancyEntity = new Vacancy();

        return vacancyEntity;
    }

    public static VacancyView exchangeEntityToView(Vacancy vacancyEntity) {
        VacancyView vacancyView = new VacancyView();

        return vacancyView;
    }
}
