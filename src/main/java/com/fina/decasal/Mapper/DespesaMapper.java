package com.fina.decasal.Mapper;

import com.fina.decasal.DTO.DespesaDTO;
import com.fina.decasal.model.Despesa;

public class DespesaMapper {

    public static DespesaDTO toDTO (Despesa despesa){

        if (despesa == null) {
            return null;
        }

    return new DespesaDTO(
    despesa.getId(),
    despesa.getDescricao(),
    despesa.getValor(),
    despesa.getDatahora(), 
    despesa.getCategoria().getId(),
    despesa.getPagador().getId()
  
    );
    }
}
