package com.neozo.ecommerce.controller;

import com.neozo.ecommerce.endpoint.impl.UserEndpointImpl;
import com.neozo.ecommerce.model.User;
import com.neozo.ecommerce.service.UserService;
import com.neozo.ecommerce.service.impl.UserServiceImpl;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    UserService userService;

    public MainController(UserServiceImpl userService) {
        System.out.println("Main Controller is created.");
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
            model.addAttribute("name", "Foo");
            return "index";
    }

    @GetMapping("/adduser")
    public String addUserForm() {
        return "adduser";
    }

    @PostMapping("/addUser")
    public String addUser(User user, Model model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.userService.addUser(user, keyHolder);
        System.out.println("The user " + user + " was added successfully!");
        model.addAttribute("user", user);
        model.addAttribute("id", keyHolder.getKey());
        return "addedsuccessfully";
    }

    @GetMapping("/showall")
    public String showAll(Model model) {
        List<User> users = this.userService.getAll();
        model.addAttribute("users", users);
        return "showall";
    }

}
