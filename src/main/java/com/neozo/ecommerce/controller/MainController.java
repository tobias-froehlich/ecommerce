package com.neozo.ecommerce.controller;

import com.neozo.ecommerce.endpoint.impl.UserEndpointImpl;
import com.neozo.ecommerce.model.User;
import com.neozo.ecommerce.service.UserService;
import com.neozo.ecommerce.service.impl.UserServiceImpl;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    UserService userService;

    public MainController(UserServiceImpl userService) {
        System.out.println("Main Controller is created.");
        this.userService = userService;
    }

    @GetMapping("/mylogin")
    public String myLogin() {
        System.out.println("Controller.myLogin().");
        return "mylogin";
    }

    @PostMapping("/loggedin")
    public String loggedin(User user, Model model) {
        System.out.println("Controller.loggedin().");
        System.out.println("model = " + model);
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", this.userService.getAll());
        model.addAttribute("info", "");
        return "index";
    }

    @GetMapping("/adduserform")
    public String addUserForm(Model model) {
        System.out.println("Model in addUserForm(): " + model);
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
        System.out.println("The model in editUserForm() is: " + model);
        System.out.println("The id for editing is " + id);
        User user = this.userService.getUser(id);
        System.out.println("The user is " + user);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "edituserform";
    }

    @PostMapping("/useredited")
    public String userEdited(User user, Model model) {
        System.out.println("The user in userEdited() is " + user);
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
        System.out.println("User in userDeleted(): " + user);
        System.out.println("Model in userDeleted(): " + model);
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
