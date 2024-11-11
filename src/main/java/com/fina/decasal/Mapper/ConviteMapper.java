package com.fina.decasal.Mapper;

import com.fina.decasal.DTO.ConviteDTO;
import com.fina.decasal.model.Convite;

public class ConviteMapper {

    public static ConviteDTO toDTO(Convite convite){
        return new ConviteDTO(convite.getCodigo(),
        convite.getStatus().name(),
        convite.getConvidado()!= null ? convite.getConvidado().getNome() : null,
        convite.getConvidante()!=null ? convite.getConvidante().getNome():null);
    }
}
