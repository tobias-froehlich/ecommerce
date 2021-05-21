package com.neozo.ecommerce.service.impl;

import com.neozo.ecommerce.endpoint.UserEndpoint;
import com.neozo.ecommerce.endpoint.impl.UserEndpointImpl;
import com.neozo.ecommerce.model.User;
import com.neozo.ecommerce.service.UserService;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    UserEndpoint userEndpoint;


    public UserServiceImpl(UserEndpointImpl userEndpoint) {
        System.out.println("UserServiceImpl is created.");
        this.userEndpoint = userEndpoint;
    }

    @Override
    public int addUser(User user, KeyHolder keyHolder) {
        System.out.println("UserServiceImpl.addUser()");
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userEndpoint.getUser(username);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.roles("ADMIN");
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }
}
