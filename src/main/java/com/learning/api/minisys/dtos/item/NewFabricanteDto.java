package com.learning.api.minisys.dtos.item;

public class NewFabricanteDto {

    private Long CODIGO;

    public NewFabricanteDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
