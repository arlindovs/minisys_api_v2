package com.learning.api.minisys.dtos.financeiro.movimentacao;

public class NewFormaPagamentoDto {

    private Long CODIGO;

    public NewFormaPagamentoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
