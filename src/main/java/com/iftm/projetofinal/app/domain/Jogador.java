package com.iftm.projetofinal.app.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {

    private Long cod_jogador;
    private String nickname;
    private String sexo;
    private String email;
    private Date data_nasc;
    private int pontuacao;
    private int moedas;

}
