package com.fina.decasal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fina.decasal.DTO.AutenticacaoDTO;
import com.fina.decasal.DTO.ResponseDTO;
import com.fina.decasal.Service.UsuarioService;
import com.fina.decasal.model.Usuario;
import com.fina.decasal.repository.UsuarioRepository;
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
    UsuarioRepository repository;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

@PostMapping("/login")
public ResponseEntity login(@RequestBody AutenticacaoDTO body) {
    Usuario user = this.repository.findByEmail(body.email())
    .orElseThrow(() -> new UsernameNotFoundException("User not found"));


    if (passwordEncoder.matches(body.senha(), user.getSenha())) {
        String token = this.tokenService.gerarToken(user);
        return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
}



    
    
           
    @PostMapping("/cadastrar")
    public Usuario cadastroUsuario(@RequestBody Usuario nvusuario) {
        nvusuario.setSenha(passwordEncoder.encode(nvusuario.getSenha()));
        return usuarioService.salvar(nvusuario);

    }
    

}
