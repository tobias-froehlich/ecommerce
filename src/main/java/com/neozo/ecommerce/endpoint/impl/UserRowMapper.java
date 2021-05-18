package com.neozo.ecommerce.endpoint.impl;

//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class UserRowMapper implements RowMapper {
//    @Override
//    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return null;
//    }
//}

import org.flywaydb.core.internal.jdbc.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs) throws SQLException {
        return null;
    }
}