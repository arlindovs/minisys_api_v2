package com.learning.api.minisys.dtos.cadastro.integrante;

public class NewIntegranteGrupoDto {

    private Long CODIGO;

    public NewIntegranteGrupoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
