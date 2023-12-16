package com.learning.api.minisys.dtos.faturamento.nota_fiscal;

public class NewNotaFiscalDto {

    private Long CODIGO;

    public NewNotaFiscalDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
