package com.headkeeper.controller;

import com.headkeeper.bean.User;
import com.headkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile/{id}/delete")
    public void deleteUser(@PathVariable int id) {
        userService.removeUser(id);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getUserPage() {
        return "registration";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String getProfile() {
        return "profile";
    }

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    public void changeProfile(@PathVariable int id,@RequestBody User user) {
        System.out.println(user.getNickname());
        userService.updateUserInfo(id, user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public void addNewUser(@RequestBody User user) {
        userService.registration(user);
    }


}
