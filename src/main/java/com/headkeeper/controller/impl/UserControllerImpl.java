package com.headkeeper.controller.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.controller.UserController;
import com.headkeeper.exception.ResourceNotFoundException;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    public void deleteUser(@PathVariable int id) {
        try {
            userService.removeUser(id);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }
    }

    public String getUserPage() {
        return "registration";
    }

    public String getProfile() {
        return "profile";
    }

    public void changeProfile(@PathVariable int id,@RequestBody User user) {
        try {
            userService.updateUserInfo(id, user);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }
    }

    public UserView getUserById(@PathVariable int id) {
        try {
            return userService.getUser(id);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }
    }

    public void addNewUser(@RequestBody User user) {
        try {
            userService.registration(user);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }
    }


}
