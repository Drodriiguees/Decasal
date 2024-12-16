package com.fina.decasal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fina.decasal.Service.UsuarioService;
import com.fina.decasal.model.Usuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
 
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/cadastrar")
    public Usuario cadastroUsuario(@RequestBody Usuario nvusuario) {
        nvusuario.setSenha(passwordEncoder.encode(nvusuario.getSenha()));
        return usuarioService.salvar(nvusuario);

    }


}
