package com.iftm.projetofinal.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.iftm.projetofinal.app.domain.Jogador;

@Component
public class GameDao {

    @Autowired
    JdbcTemplate data;

    public List<Jogador> getJogadores() {
        String sql = "select * from jogador";

        return data.query(sql, (res, rowNum) -> {
            return new Jogador(
                    res.getInt("cod_jogador"),
                    res.getString("nickname"),
                    res.getString("email"),
                    res.getDate("data_nasc"),
                    res.getInt("pontuacao"));
        });
    }

    public Jogador getJogador(String nickname) {
        return busca("nickname", "jogador", nickname);
    }

    private Jogador busca(String tipo, String tabela, String valor) {
        String sql = "select * from " + tabela + " where " + tipo + " = ?";
        List<Jogador> jogadores = data.query(sql,
                new BeanPropertyRowMapper<>(Jogador.class),
                new Object[] { valor });

        if (jogadores != null && !jogadores.isEmpty()) {
            return jogadores.get(0);
        } else {
            return null;
        }
    }

}