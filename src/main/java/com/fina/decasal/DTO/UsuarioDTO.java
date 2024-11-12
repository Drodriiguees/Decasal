package com.fina.decasal.DTO;

import com.fina.decasal.enums.UsuarioRole;

public record UsuarioDTO(
    String nome,
    String email,
    UsuarioRole role
) {}

   
