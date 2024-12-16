package com.fina.decasal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fina.decasal.repository.UsuarioRepository;

@Component
public class ComstumizarUserDetailsService implements UserDetailsService{

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return repository.findByEmail(username);
    }

}
