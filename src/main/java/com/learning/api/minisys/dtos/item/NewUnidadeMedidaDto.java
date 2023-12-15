package com.learning.api.minisys.dtos.item;

public class NewUnidadeMedidaDto {

    private Long CODIGO;

    public NewUnidadeMedidaDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
