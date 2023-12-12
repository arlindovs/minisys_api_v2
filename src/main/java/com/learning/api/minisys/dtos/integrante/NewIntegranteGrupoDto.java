package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;

public class NewIntegranteGrupoDto {

    private Long CODIGO;

    public NewIntegranteGrupoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
