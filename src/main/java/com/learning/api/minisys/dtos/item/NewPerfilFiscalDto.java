package com.learning.api.minisys.dtos.item;

public class NewPerfilFiscalDto {

    private Long CODIGO;

    public NewPerfilFiscalDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
