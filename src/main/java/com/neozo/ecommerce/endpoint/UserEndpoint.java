package com.neozo.ecommerce.endpoint;

import com.neozo.ecommerce.model.User;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public interface UserEndpoint {
    int addUser(User user, KeyHolder keyHolder);
    User getUser(long id);
    User getUser(String username);
    void editUser(User user);
    void deleteUser(long id);
    List<User> getAll();

}
