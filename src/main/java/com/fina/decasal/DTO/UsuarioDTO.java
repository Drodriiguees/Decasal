package com.fina.decasal.DTO;

import com.fina.decasal.enums.UsuarioRole;

public record UsuarioDTO(
    Long id,
    String nome,
    String email,
    UsuarioRole role
) {}

   
