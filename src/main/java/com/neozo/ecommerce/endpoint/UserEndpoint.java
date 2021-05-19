package com.neozo.ecommerce.endpoint;

import com.neozo.ecommerce.model.User;

import java.util.List;

public interface UserEndpoint {
    int addUser(User user);
    List<User> getAll();
}
