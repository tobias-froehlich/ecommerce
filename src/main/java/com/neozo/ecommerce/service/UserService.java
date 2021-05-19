package com.neozo.ecommerce.service;

import com.neozo.ecommerce.model.User;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public interface UserService {

    int addUser(User user, KeyHolder keyHolder);

    List<User> getAll();

}
