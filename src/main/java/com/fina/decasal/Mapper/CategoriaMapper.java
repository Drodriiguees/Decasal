package com.fina.decasal.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fina.decasal.DTO.CategoriaDTO;
import com.fina.decasal.model.Categoria;
import com.fina.decasal.model.Despesa;

public class CategoriaMapper {

    public static CategoriaDTO toDTO (Categoria categoria){
        List<Long> despesaIds = categoria.getDespesas().stream().map(Despesa::getId).collect(Collectors.toList());
        return new CategoriaDTO(categoria.getNome(), despesaIds);
    }
        
    }

