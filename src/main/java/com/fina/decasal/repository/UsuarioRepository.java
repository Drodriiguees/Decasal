package com.fina.decasal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.fina.decasal.model.Usuario;


public interface UsuarioRepository extends JpaRepository< Usuario, Long> {
    UserDetails findByEmail(String email);

}
