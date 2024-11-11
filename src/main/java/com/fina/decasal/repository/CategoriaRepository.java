package com.fina.decasal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fina.decasal.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    List<Categoria> findByNome(String nome);
}
