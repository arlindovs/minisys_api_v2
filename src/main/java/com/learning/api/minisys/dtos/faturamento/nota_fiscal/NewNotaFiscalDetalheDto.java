package com.learning.api.minisys.dtos.faturamento.nota_fiscal;

public class NewNotaFiscalDetalheDto {

    private Long CODIGO;

    public NewNotaFiscalDetalheDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
