package com.learning.api.minisys.dtos.cadastro.item;

public class NewItemDto {

    private Long CODIGO;

    public NewItemDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
