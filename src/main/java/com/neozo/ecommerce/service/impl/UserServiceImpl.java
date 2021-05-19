package com.neozo.ecommerce.service.impl;

import com.neozo.ecommerce.endpoint.UserEndpoint;
import com.neozo.ecommerce.endpoint.impl.UserEndpointImpl;
import com.neozo.ecommerce.model.User;
import com.neozo.ecommerce.service.UserService;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {
    UserEndpoint userEndpoint;


    public UserServiceImpl(UserEndpointImpl userEndpoint) {
        System.out.println("UserServiceImpl is created.");
        this.userEndpoint = userEndpoint;
    }

    @Override
    public int addUser(User user, KeyHolder keyHolder) {
        System.out.println("UserServiceImpl.addUser()");
        return userEndpoint.addUser(user, keyHolder);
    }

    @Override
    public List<User> getAll() {
        return this.userEndpoint.getAll();
    }
}
