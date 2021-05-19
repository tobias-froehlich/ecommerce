package com.neozo.ecommerce.endpoint.impl;

import com.neozo.ecommerce.endpoint.UserEndpoint;
import com.neozo.ecommerce.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
        return this.template.update(INSERT_QUERY, new BeanPropertySqlParameterSource(user));
    }

    @Override
    public List<User> getAll() {
        Map<String, Object> paramMap = new HashMap<>();
        List<User> users = this.template.query(SELECT_QUERY, new BeanPropertyRowMapper<>(User.class));
        return users;
    }
}
