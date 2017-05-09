package com.headkeeper.controller.impl;

import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.TokenView;
import com.headkeeper.bean.view.UserLoginView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.controller.UserController;
import com.headkeeper.controller.util.Validator;
import com.headkeeper.exception.ResourceNotFoundException;
import com.headkeeper.exception.ValidationException;
import com.headkeeper.security.service.GetTokenService;
import com.headkeeper.security.service.exception.AuthenticationException;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public TokenView addNewCompany(@RequestBody CompanyInfoView companyInfo) throws AuthenticationException {
        String token;
        String generatedPassword = companyInfo.getUser().getPassword();
        if (!Validator.validateEmail(companyInfo.getUser().getEmail())) {
            throw new ValidationException("Invalid email!");
        }

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update("salad".getBytes("UTF-8"));
            byte[] bytes = md.digest(companyInfo.getUser().getPassword().getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = stringBuilder.toString();
            companyInfo.getUser().setPassword(generatedPassword);

            userService.registration(companyInfo.getUser());
            userService.addCompany(companyInfo, userService.getUserByEmail(companyInfo.getUser().getEmail()).getId());

        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        token = getTokenService.getToken(companyInfo.getUser().getEmail(), generatedPassword);
        return new TokenView(token);
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

    public TokenView login(@RequestBody UserLoginView userLogin) throws AuthenticationException {
        String token;
        String generatedPassword = userLogin.getPassword();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update("salad".getBytes("UTF-8"));
            byte[] bytes = md.digest(userLogin.getPassword().getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = stringBuilder.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        token = getTokenService.getToken(userLogin.getEmail(), generatedPassword);
        return new TokenView(token);
    }

    public TokenView addNewUser(@RequestBody UserView user) throws AuthenticationException {
        String token;
        if (!Validator.validateUser(user)) {
            throw new AuthenticationException("Invalid user info!");
        }
        String generatedPassword = user.getPassword();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update("salad".getBytes("UTF-8"));
            byte[] bytes = md.digest(user.getPassword().getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = stringBuilder.toString();
            user.setPassword(generatedPassword);
            userService.registration(user);

        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        token = getTokenService.getToken(user.getEmail(), generatedPassword);
        return new TokenView(token);
    }
}
