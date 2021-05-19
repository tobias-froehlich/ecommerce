package com.neozo.ecommerce.endpoint.impl;

import com.neozo.ecommerce.endpoint.UserEndpoint;
import com.neozo.ecommerce.model.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserEndpointImpl implements UserEndpoint {
    NamedParameterJdbcTemplate template;
    final String INSERT_QUERY = "INSERT INTO users (firstName, lastName) values (:firstName, :lastName)";
    final String SELECT_QUERY = "SELECT * from users";

    public UserEndpointImpl(NamedParameterJdbcTemplate template) {
        System.out.println("EndpointImpl is created.");
        this.template = template;
    }

    @Override
    public int addUser(User user) {
        System.out.println("UserEndpointimpl.addUser()");
        if (user == null) {
            return 0;
        }
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", user.getFirstName());
        paramMap.put("lastName", user.getLastName());
        return this.template.update(INSERT_QUERY, paramMap);
    }

    @Override
    public List<User> getAll() {
        Map<String, Object> paramMap = new HashMap<>();
        List<Map<String, Object>> list = this.template.queryForList(SELECT_QUERY, paramMap);
        List<User> users = new ArrayList<>();
        for(Map<String, Object> item : list) {
            User user = new User();
            user.setId((int)item.get("id"));
            user.setFirstName((String)item.get("firstName"));
            user.setLastName((String)item.get("LastName"));
            users.add(user);
        }
        return users;
    }
}
