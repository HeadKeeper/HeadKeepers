package com.headkeeper.controller.impl;

import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.TokenView;
import com.headkeeper.bean.view.UserLoginView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.controller.UserController;
import com.headkeeper.controller.exception.ControllerException;
import com.headkeeper.controller.exception.ExistsControllerException;
import com.headkeeper.controller.exception.NotFoundControllerException;
import com.headkeeper.controller.exception.WrongInputControllerException;
import com.headkeeper.controller.util.ArgumentUtil;
import com.headkeeper.controller.util.Validator;
import com.headkeeper.exception.ResourceNotFoundException;
import com.headkeeper.exception.ValidationException;
import com.headkeeper.security.service.GetTokenService;
import com.headkeeper.security.service.exception.AuthenticationException;
import com.headkeeper.service.UserService;
import com.headkeeper.service.exception.ExistsServiceException;
import com.headkeeper.service.exception.NotFoundServiceException;
import com.headkeeper.service.exception.ServiceException;
import com.headkeeper.service.exception.WrongInputServiceException;
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

    public void deleteUser(@PathVariable int id) throws ControllerException {
        try {
            userService.removeUser(id);
        } catch (ServiceException e) {
            throw new ResourceNotFoundException(e);
        }
    }

    public String getUserPage() {
        return "registration";
    }

    public TokenView addNewCompany(@RequestBody CompanyInfoView companyInfo) throws AuthenticationException, ControllerException {
        if (!Validator.validateEmail(companyInfo.getUser().getEmail())) {
            throw new ValidationException("Invalid email!");
        }

        try {
            String generatedPassword = ArgumentUtil.generatePass(companyInfo.getUser().getPassword());
            companyInfo.getUser().setPassword(generatedPassword);

            userService.registration(companyInfo.getUser());
            userService.addCompany(companyInfo, userService.getUserByEmail(companyInfo.getUser().getEmail()).getId());

            String token = getTokenService.getToken(companyInfo.getUser().getEmail(), generatedPassword);
            return new TokenView(token);
        } catch (ExistsServiceException e) {
            throw new ExistsControllerException("User already exists", e);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User doesn't exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public String getProfile() throws ControllerException {
        return "profile";
    }

    public void changeProfile(@PathVariable int id,@RequestBody UserView user) throws ControllerException {
        try {
            userService.updateUserInfo(id, user);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public UserView getUserById(@PathVariable int id) throws ControllerException {
        try {
            return userService.getUser(id);
        } catch (NotFoundServiceException e) {
            throw new NotFoundControllerException("User already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }

    public TokenView login(@RequestBody UserLoginView userLogin) throws AuthenticationException, ControllerException {
        String generatedPassword = ArgumentUtil.generatePass(userLogin.getPassword());
        userLogin.setPassword(generatedPassword);
        String token = getTokenService.getToken(userLogin.getEmail(), generatedPassword);
        return new TokenView(token);
    }

    public TokenView addNewUser(@RequestBody UserView user) throws AuthenticationException, ControllerException {
        if (!Validator.validateUser(user)) {
            throw new AuthenticationException("Invalid user info!");
        }
        try {
            String generatedPassword = ArgumentUtil.generatePass(user.getPassword());
            user.setPassword(generatedPassword);
            userService.registration(user);
            String token = getTokenService.getToken(user.getEmail(), generatedPassword);
            return new TokenView(token);
        } catch (ExistsServiceException e) {
            throw new ExistsControllerException("User already exists", e);
        } catch (WrongInputServiceException e) {
            throw new WrongInputControllerException("Input fields are incorrect", e);
        } catch (ServiceException | AuthenticationException e) {
            throw new ControllerException("Error while perform registration", e);
        }
    }
}
