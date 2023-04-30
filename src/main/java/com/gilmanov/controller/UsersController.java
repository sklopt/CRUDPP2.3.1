package com.gilmanov.controller;

import com.gilmanov.dao.DaoException;
import com.gilmanov.entity.User;
import com.gilmanov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/users/save")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "saveUser";
    }

    @PostMapping(value = "/users/save")
    public String addUser(@ModelAttribute("user") User user) throws DaoException {
        service.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "users/change/{id}")
    public String editUser(ModelMap model, @PathVariable("id") long id) throws DaoException {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "changeUser";
    }

    @PostMapping(value = "users/change")
    public String edit(@ModelAttribute("user") User user) throws DaoException {
        service.changeUser(user);
        return "redirect:/users";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") long id) throws DaoException {
        service.removeUserById(id);
        return "redirect:/users";
    }

}
