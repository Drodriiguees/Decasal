package com.fina.decasal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fina.decasal.model.Usuario;

public interface UsuarioRepository extends JpaRepository< Usuario, Long> {

}
