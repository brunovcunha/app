package com.iftm.projetofinal.app.domain;
import java.util.List;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class Login {
    @NonNull
    private String login;
    @NonNull
    private String senha;

    private List<Role> roles;
}
