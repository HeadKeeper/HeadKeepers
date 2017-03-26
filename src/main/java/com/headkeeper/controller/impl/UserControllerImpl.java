package com.headkeeper.controller.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.controller.UserController;
import com.headkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    public void deleteUser(@PathVariable int id) {
        userService.removeUser(id);
    }

    public String getUserPage() {
        return "registration";
    }

    public String getProfile() {
        return "profile";
    }

    public void changeProfile(@PathVariable int id,@RequestBody User user) {
        userService.updateUserInfo(id, user);
    }

    public UserView getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

    public void addNewUser(@RequestBody User user) {
        userService.registration(user);
    }


}
