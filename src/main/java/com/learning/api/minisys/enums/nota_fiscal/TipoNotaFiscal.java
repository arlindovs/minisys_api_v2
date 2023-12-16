package com.learning.api.minisys.enums.nota_fiscal;

public enum TipoNotaFiscal {

    ENTRADA("Entrada"),
    SAIDA("Saída"),
    SERVICO("Serviço");

    private String descricao;

    TipoNotaFiscal(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
