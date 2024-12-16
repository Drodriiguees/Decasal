package com.fina.decasal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fina.decasal.repository.UsuarioRepository;



public class AutorizacaoService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nomeusuario) throws UsernameNotFoundException {
        return repository.findByEmail(nomeusuario);

 
    }

}
