package com.learning.api.minisys.dtos.integrante;

public class NewIntegranteDto {

    private Long CODIGO;

    public NewIntegranteDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
