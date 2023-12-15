package com.iftm.projetofinal.app.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poder {
    private int cod_poder;
    private String habilidade;
    private String descricao;
}
