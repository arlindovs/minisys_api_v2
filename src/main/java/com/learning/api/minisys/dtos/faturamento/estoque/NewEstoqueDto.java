package com.learning.api.minisys.dtos.faturamento.estoque;

public class NewEstoqueDto {

    private Long CODIGO;

    public NewEstoqueDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
