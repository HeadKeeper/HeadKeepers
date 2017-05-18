package com.headkeeper.controller;

import com.headkeeper.bean.view.CompanyInfoView;
import com.headkeeper.bean.view.TokenView;
import com.headkeeper.bean.view.UserLoginView;
import com.headkeeper.bean.view.UserView;
import com.headkeeper.controller.exception.ControllerException;
import com.headkeeper.security.service.exception.AuthenticationException;
import com.headkeeper.service.exception.ServiceException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface UserController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    String getUserPage() throws ControllerException;

    @RequestMapping(value = "/registration/company", method = RequestMethod.POST)
    @ResponseBody
    TokenView addNewCompany(@Validated @RequestBody CompanyInfoView companyInfo) throws AuthenticationException, ControllerException;

    @RequestMapping(value = "/registration/user", method = RequestMethod.POST)
    @ResponseBody
    TokenView addNewUser(@RequestBody UserView user) throws AuthenticationException, ControllerException;

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    String getProfile() throws ControllerException;

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    void changeProfile(@PathVariable int id,@RequestBody UserView user) throws ControllerException;

    @RequestMapping(value = "/user/{id}/delete")
    void deleteUser(@PathVariable int id) throws ControllerException;

    @PreAuthorize("hasAuthority('user')")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    UserView getUserById(@PathVariable int id) throws ControllerException;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    TokenView login(@RequestBody UserLoginView userLogin) throws AuthenticationException, ControllerException;
}
