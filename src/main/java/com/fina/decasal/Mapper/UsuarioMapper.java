package com.fina.decasal.Mapper;

import com.fina.decasal.DTO.UsuarioDTO;
import com.fina.decasal.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO (Usuario usuario){
        if (usuario == null) {
            return null;
        }
        return new UsuarioDTO( 
        usuario.getNome(),
        usuario.getEmail(),
        usuario.getRole()
        );
    }


    public static Usuario fromDTO (UsuarioDTO usuarioDTO){
        if (usuarioDTO == null) {
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        return usuario;
    }
}
