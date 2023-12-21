package com.learning.api.minisys.dtos.cadastro.integrante.table;

import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;

public record IntegranteTableDto(

        Long CODIGO,

        String nome
) {

    public IntegranteTableDto(IntegranteEntity integranteEntity) {
        this(integranteEntity.getCODIGO(),
                integranteEntity.getNome());
    }
}
