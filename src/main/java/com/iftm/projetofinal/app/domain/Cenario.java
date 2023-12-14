package com.iftm.projetofinal.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cenario {
    private int cod_cenario;
    private String caracteristicas;
    private int qtde_min_pontos;
}
