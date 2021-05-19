package com.neozo.ecommerce.service;

import com.neozo.ecommerce.model.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> getAll();

}
