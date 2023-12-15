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
                    res.getString("apelido"),
                    res.getString("senha"),
                    res.getDate("data_nasc"),
                    res.getInt("pontuacao"));
        });
    }

    public List<Jogador> getJogador(String apelido) {
        String sql = "select * from jogador where lower(apelido) like ?";

        return database.query(sql,
                new BeanPropertyRowMapper<>(Jogador.class),
                new Object[] { "%" + apelido + "%" });

    }

    public Jogador getJogador(int id) {
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
        String sql = "insert into jogador(apelido, senha, data_nasc, pontuacao) values (?, ?, ?, 0)";

        database.update(sql, new Object[] {
                jogador.getApelido(),
                jogador.getSenha(),
                jogador.getData_nasc()});
    }
    
    public void atualizarJogador(Jogador jogador) {
        String sql = "update jogador set apelido = ?, senha = ?, pontuacao = ? where cod_jogador = ?";

        database.update(sql,
                jogador.getApelido(),
                jogador.getSenha(),
                jogador.getPontuacao(),
                jogador.getCod_jogador());
    }

    public void apagarJogador(int cod_jogador) {
        String sql = "delete from jogador where cod_jogador = ?";
        database.update(sql, new Object[] { cod_jogador });
    }

}