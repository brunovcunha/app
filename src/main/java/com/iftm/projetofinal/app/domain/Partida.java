package com.iftm.projetofinal.app.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
    private int cod_partida;
    private Date data_hora_inicio;
    private Date data_hora_termino;
    private int pontos_obtidos;
    private int cod_jogador;
    private int cod_cenario;
}
