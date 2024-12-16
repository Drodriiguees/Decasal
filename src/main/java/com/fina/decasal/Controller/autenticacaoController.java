package com.fina.decasal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fina.decasal.DTO.AutenticacaoDTO;
import com.fina.decasal.Service.UsuarioService;
import com.fina.decasal.model.Usuario;
import com.fina.decasal.seguranca.TokenService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class autenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;


    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AutenticacaoDTO data) {
       
        var usernamepassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        this.authenticationManager.authenticate(usernamepassword);
        
        return ResponseEntity.ok().build();
    }
    
           
    @PostMapping("/cadastrar")
    public Usuario cadastroUsuario(@RequestBody Usuario nvusuario) {
        nvusuario.setSenha(passwordEncoder.encode(nvusuario.getSenha()));
        return usuarioService.salvar(nvusuario);

    }
    

}
