package com.headkeeper.controller;

import com.headkeeper.bean.User;
import org.springframework.web.bind.annotation.*;

public interface UserController {
    @RequestMapping(value = "/profile/{id}/delete")
    void deleteUser(@PathVariable int id);

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    String getUserPage();

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    String getProfile();

    @RequestMapping(value = "/profile/{id}", method = RequestMethod.POST)
    void changeProfile(@PathVariable int id,@RequestBody User user);

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    User getUserById(@PathVariable int id);

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    void addNewUser(@RequestBody User user);

}
