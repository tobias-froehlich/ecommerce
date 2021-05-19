package com.neozo.ecommerce.controller;

import com.neozo.ecommerce.endpoint.impl.UserEndpointImpl;
import com.neozo.ecommerce.model.User;
import com.neozo.ecommerce.service.UserService;
import com.neozo.ecommerce.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String addUser(
            @RequestParam String firstName,
            @RequestParam String lastName,
            Model model) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        this.userService.addUser(user);
        return "adduser";
    }

    @GetMapping("/showall")
    public String showAll(Model model) {
        List<User> users = this.userService.getAll();
        model.addAttribute("users", users);
        return "showall";
    }

}
