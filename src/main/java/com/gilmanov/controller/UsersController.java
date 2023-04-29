package com.gilmanov.controller;

import com.gilmanov.dao.DaoException;
import com.gilmanov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    private final UserService service;
    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) throws DaoException {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }
}
