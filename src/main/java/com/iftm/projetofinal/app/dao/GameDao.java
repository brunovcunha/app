package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.iftm.projetofinal.app.domain.Jogador;


@Component
public class GameDao {

    @Autowired
    JdbcTemplate db;

    public List<Jogador> getJogadoresList() {
        String sql = "select cod_jogador, nickname, email nickname from jogador";
        return db.query(sql, (res, rowNum) -> {
            return new Jogador(
                res.getLong("cod_jogador"),
                res.getString("nickname"),
                res.getString("sexo"),
                res.getString("email"),
                res.getDate("data_nasc"),
                res.getInt("pontuacao"),
                res.getInt("moedas")
            );
        });
    }   
}