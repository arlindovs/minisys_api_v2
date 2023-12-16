package com.learning.api.minisys.dtos.financeiro.titulo;

public class NewTituloDto {

    private Long CODIGO;

    public NewTituloDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
