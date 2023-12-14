package com.iftm.projetofinal.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class GameDao {

    @Autowired
    JdbcTemplate data;


    
}