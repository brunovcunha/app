package com.iftm.projetofinal.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {
    @NonNull
    private Integer id;
    @NonNull
    private String nome;
}
