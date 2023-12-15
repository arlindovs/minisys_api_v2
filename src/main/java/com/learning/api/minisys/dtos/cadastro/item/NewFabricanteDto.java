package com.learning.api.minisys.dtos.cadastro.item;

public class NewFabricanteDto {

    private Long CODIGO;

    public NewFabricanteDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
