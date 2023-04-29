package com.gilmanov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/crud")
public class UsersController {
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getCRUD(ModelMap model) {
        return "My CRUD";
    }
}
