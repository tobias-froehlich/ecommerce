package com.neozo.ecommerce.endpoint.impl;

import com.neozo.ecommerce.endpoint.Endpoint;
import com.neozo.ecommerce.model.User;
import org.flywaydb.core.internal.database.mysql.mariadb.MariaDBDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EndpointImpl implements Endpoint {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        System.out.println(jdbcTemplate);
    }
}
