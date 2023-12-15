package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Login;
import com.iftm.projetofinal.app.domain.Role;

@Component
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(LoginDao.class);

    public void salvar(Login login) {
        String sql = "INSERT INTO login (usuario, senha) VALUES (?, ?)";
        jdbcTemplate.update(sql, login.getUsuario(), login.getSenha());
    }


    public Login getLogin(String user) {
        String sql = "SELECT usuario, senha FROM login WHERE login = ?";
        try {
            Login login = jdbcTemplate.queryForObject(sql,
                (res, rowNum) -> {
                    Login userLogin = new Login(
                            res.getString("usuario"),
                            res.getString("senha"));
                    userLogin.setRoles(getRoles(user));
                    return userLogin;
                }, new Object[] { user });
    
            return login;
        } catch (EmptyResultDataAccessException e) {
            logger.info("Usuário não encontrado " + user + " message: " + e);
            return null;
        }
    }
    

    public List<Role> getRoles(String user) {
        String sql = "select id,nome from tb_role where id in (select role_id from tb_role_user where usuario = ?)";
        List<Role> roles = jdbcTemplate.query(sql,
            (res, rowNum) -> {
                return new Role(
                    res.getInt("id"),
                    res.getString("nome"));
            },
            new Object[] { user });
        logger.info("Roles para o usuário " + user + ": " + roles);
        return roles;
    }
    
}
