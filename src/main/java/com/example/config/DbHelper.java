package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DbHelper {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DbHelper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveEvent(String name) {
        jdbcTemplate.update(
                "insert into events (date, name) values (current_date, ?)",
                name);
    }

    public String test(){
        return "rest" + jdbcTemplate.toString();
    }
}
