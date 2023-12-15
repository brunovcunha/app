package com.iftm.projetofinal.app.DTO;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class MenuItem {
    private String link;
    private String nome;
}
