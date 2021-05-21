package com.neozo.ecommerce.service.impl;

import com.neozo.ecommerce.endpoint.UserEndpoint;
import com.neozo.ecommerce.endpoint.impl.UserEndpointImpl;
import com.neozo.ecommerce.model.User;
import com.neozo.ecommerce.service.UserService;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserEndpoint userEndpoint;


    public UserServiceImpl(UserEndpointImpl userEndpoint) {
        this.userEndpoint = userEndpoint;
    }

    @Override
    public int addUser(User user, KeyHolder keyHolder) {
        return this.userEndpoint.addUser(user, keyHolder);
    }

    @Override
    public User getUser(long id) {
        return this.userEndpoint.getUser(id);
    }

    @Override
    public void editUser(User user) {
        this.userEndpoint.editUser(user);
    }

    @Override
    public void deleteUser(long id) {
        this.userEndpoint.deleteUser(id);
    }

    @Override
    public List<User> getAll() {
        return this.userEndpoint.getAll();
    }

}
