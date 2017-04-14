package com.headkeeper.controller.impl;

import com.headkeeper.bean.entity.User;
import com.headkeeper.bean.view.TokenView;
import com.headkeeper.bean.view.UserLoginView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.controller.UserController;
import com.headkeeper.exception.ResourceNotFoundException;
import com.headkeeper.security.service.GetTokenService;
import com.headkeeper.security.service.exception.AuthenticationException;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private GetTokenService getTokenService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGetTokenService(GetTokenService getTokenService) {
        this.getTokenService = getTokenService;
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

    public void changeProfile(@PathVariable int id,@RequestBody UserView user) {
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

    @Override
    public TokenView login(UserLoginView userLogin) throws AuthenticationException {

    }

    public void addNewUser(@RequestBody UserView user) {
        try {
            userService.registration(user);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }
    }
}
