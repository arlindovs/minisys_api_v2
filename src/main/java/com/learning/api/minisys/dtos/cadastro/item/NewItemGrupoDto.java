package com.learning.api.minisys.dtos.cadastro.item;

public class NewItemGrupoDto {

    private Long CODIGO;

    public NewItemGrupoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
