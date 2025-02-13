package com.fina.decasal.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fina.decasal.DTO.CategoriaDTO;
import com.fina.decasal.model.Categoria;
import com.fina.decasal.repository.CategoriaRepository;

@Service
public class CategoriaService {
     
    @Autowired
    private CategoriaRepository repository;

    public Categoria salvar(Categoria novaCat){
        return repository.save(novaCat);
    }

    public void deletar (Long id){
        repository.deleteById(id);
    }

    public Categoria editar (Long id, CategoriaDTO novCategoriaDTO){
     Categoria catexistente = repository.findById(id).orElse(null);
     if (catexistente != null ) {
        catexistente.setNome(novCategoriaDTO.nome());
        return repository.save(catexistente);
     }
     return null;
    }

    public List<Categoria> listar() {
        return repository.findAll(); 
    }
    
}
