package com.learning.api.minisys.dtos.financeiro.movimentacao;

public class NewMovimentacaoDto {

    private Long CODIGO;

    public NewMovimentacaoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
