package com.headkeeper.controller;

import com.headkeeper.bean.entity.UserResume;
import org.springframework.web.bind.annotation.*;

public interface LaborExchangeController {

    /* ------------------------------------------ RESUME CONTROLLING ------------------------------------------- */

    @RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
    @ResponseBody
    UserResume getResumeById(@PathVariable int id);

    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    String getResumePage();

    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    void addNewResume(@RequestBody UserResume resume);
}
