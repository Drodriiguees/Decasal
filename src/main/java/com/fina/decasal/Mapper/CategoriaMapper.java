package com.fina.decasal.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.fina.decasal.DTO.CategoriaDTO;
import com.fina.decasal.model.Categoria;

public class CategoriaMapper {

    public static CategoriaDTO toDTO (Categoria categoria){
        return new CategoriaDTO(categoria.getNome());
    }
        

    public static List <CategoriaDTO> toList (List<Categoria> categorias){
        return categorias.stream().map(CategoriaMapper::toDTO).collect(Collectors.toList());
    }
    }

