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
    JdbcTemplate database;

    public List<Jogador> getJogadores() {
        String sql = "select * from jogador";

        return database.query(sql, (res, rowNum) -> {
            return new Jogador(
                    res.getInt("cod_jogador"),
                    res.getString("nickname"),
                    res.getString("senha"),
                    res.getDate("data_nasc"),
                    res.getInt("pontuacao"));
        });
    }

    public List<Jogador> getJogador(String nickname) {
        String sql = "select * from jogador where lower(nickname) like ?";

        return database.query(sql,
                new BeanPropertyRowMapper<>(Jogador.class),
                new Object[] { "%" + nickname + "%" });

    }

    private Jogador getJogador(int id) {
        String sql = "select * from jogador where id = ?";
        
        List<Jogador> jogadores = database.query(sql,
                new BeanPropertyRowMapper<>(Jogador.class),
                new Object[] { id });

        if (jogadores != null && !jogadores.isEmpty()) {
            return jogadores.get(0);
        } else {
            return null;
        }
    }

    public void cadastrarJogador(Jogador jogador) {
        String sql = "insert into jogador(nickname, senha, data_nasc, pontuacao) values (?, ?, ?, 0)";

        database.update(sql, new Object[] {
                jogador.getNickname(),
                jogador.getSenha(),
                jogador.getData_nasc()});
    }
    
    public void atualizarJogador(Jogador jogador) {
        String sql = "update jogador set nickname = ?, senha = ?, pontuacao = ? where cod_jogador = ?";

        database.update(sql,
                jogador.getNickname(),
                jogador.getSenha(),
                jogador.getPontuacao(),
                jogador.getCod_jogador());
    }

    public void apagarJogador(int cod_jogador) {
        String sql = "delete from jogador where cod_jogador = ?";
        database.update(sql, new Object[] { cod_jogador });
    }

}