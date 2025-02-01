package com.fina.decasal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fina.decasal.model.Usuario;
import com.fina.decasal.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Usuario salvar (Usuario usuario){
        return repository.save(usuario);
    }
    
}
