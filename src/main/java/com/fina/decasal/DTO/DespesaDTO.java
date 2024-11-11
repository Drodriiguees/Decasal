package com.fina.decasal.DTO;

import java.util.Date;

public record DespesaDTO(
    Long id,
    String descricao,
    Double valor,
    Date datahora,
    Long categoriaId,
    Long pagadorId
) {}
