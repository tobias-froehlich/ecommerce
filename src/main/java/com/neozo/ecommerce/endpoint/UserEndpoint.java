package com.neozo.ecommerce.endpoint;

import com.neozo.ecommerce.model.User;
import org.springframework.jdbc.support.KeyHolder;

import java.util.List;

public interface UserEndpoint {
    int addUser(User user, KeyHolder keyHolder);
    List<User> getAll();
}
