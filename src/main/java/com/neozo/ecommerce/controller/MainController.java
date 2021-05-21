package com.neozo.ecommerce.controller;

import com.neozo.ecommerce.model.User;
import com.neozo.ecommerce.service.UserService;
import com.neozo.ecommerce.service.impl.UserServiceImpl;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    UserService userService;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", this.userService.getAll());
        model.addAttribute("info", "");
        return "index";
    }

    @GetMapping("/adduserform")
    public String addUserForm() {
        return "adduserform";
    }

    @PostMapping("/useradded")
    public String userAdded(User user, Model model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.userService.addUser(user, keyHolder);
        model.addAttribute("users", this.userService.getAll());
        StringBuilder info = new StringBuilder();
        info.append("The user ");
        info.append(user.getFirstName());
        info.append(" ");
        info.append(user.getLastName());
        info.append(" was added successfully with ID ");
        info.append(keyHolder.getKey());
        info.append(".");
        model.addAttribute("info", info.toString());
        return "index";
    }

    @GetMapping("/edituserform")
    public String editUserForm(Model model, @RequestParam("id") long id) {
        User user = this.userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "edituserform";
    }

    @PostMapping("/useredited")
    public String userEdited(User user, Model model) {
        this.userService.editUser(user);
        model.addAttribute("users", this.userService.getAll());
        StringBuilder info = new StringBuilder();
        info.append("User with ID " + user.getId());
        info.append(" was edited and is now " + user.getFirstName() + " " + user.getLastName());
        model.addAttribute("info", info.toString());
        return "index";
    }

    @GetMapping("/deleteuserform")
    public String deleteUserForm(Model model, @RequestParam("id") long id) {
        User user = this.userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "deleteuserform";
    }

    @PostMapping("/userdeleted")
    public String userDeleted(User user, Model model) {
        this.userService.deleteUser(user.getId());
        model.addAttribute("users", this.userService.getAll());
        StringBuilder info = new StringBuilder();
        info.append("The user ");
        info.append(user.getFirstName());
        info.append(" ");
        info.append(user.getLastName());
        info.append(" with ID ");
        info.append(user.getId());
        info.append(" was deleted.");
        model.addAttribute("info", info.toString());
        return "index";
    }

}
