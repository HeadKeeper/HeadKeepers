package com.headkeeper.controller;

import com.headkeeper.bean.view.UserView;
import org.springframework.web.bind.annotation.*;

public interface UserController {
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    String getUserPage();

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    void addNewUser(@RequestBody UserView user);

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    String getProfile();

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    void changeProfile(@PathVariable int id,@RequestBody UserView user);

    @RequestMapping(value = "/profile/{id}/delete")
    void deleteUser(@PathVariable int id);

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    UserView getUserById(@PathVariable int id);
}
