package com.neozo.ecommerce.endpoint.impl;

import com.neozo.ecommerce.endpoint.UserEndpoint;
import com.neozo.ecommerce.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserEndpointImpl implements UserEndpoint {
    NamedParameterJdbcTemplate template;
    final String INSERT_QUERY = "INSERT INTO users (firstName, lastName, username, password) values (:firstName, :lastName, :username, :password)";
    final String SELECT_ALL_QUERY = "SELECT * FROM users";
    final String SELECT_BY_ID_QUERY = "SELECT * FROM users WHERE id=:id";
    final String SELECT_BY_USERNAME_QUERY = "SELECT * FROM users WHERE username=:username";
    final String UPDATE_QUERY = "UPDATE users SET firstName=:firstName, lastName=:lastName, username=:username, password=:password WHERE id=:id";
    final String DELETE_BY_ID_QUERY = "DELETE FROM users WHERE id=:id";

    public UserEndpointImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public int addUser(User user, KeyHolder keyHolder) {
        return this.template.update(INSERT_QUERY, new BeanPropertySqlParameterSource(user), keyHolder);
    }

    @Override
    public User getUser(long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<User> list = this.template.query(SELECT_BY_ID_QUERY, paramMap, new BeanPropertyRowMapper<>(User.class));
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUser(String username) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        List<User> list = this.template.query(SELECT_BY_USERNAME_QUERY, paramMap, new BeanPropertyRowMapper<>(User.class));
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void editUser(User user) {
        this.template.update(UPDATE_QUERY, new BeanPropertySqlParameterSource(user));
    }

    @Override
    public void deleteUser(long id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        this.template.update(DELETE_BY_ID_QUERY, paramMap);
    }

    @Override
    public List<User> getAll() {

        Map<String, Object> paramMap = new HashMap<>();
        List<User> users = this.template.query(SELECT_ALL_QUERY, new BeanPropertyRowMapper<>(User.class));
        return users;
    }
}
