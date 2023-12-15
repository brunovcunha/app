package com.iftm.projetofinal.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {
    private int cod_jogador;
    private String nickname;
    private String senha;
    private Date data_nasc;
    private int pontuacao;
}
