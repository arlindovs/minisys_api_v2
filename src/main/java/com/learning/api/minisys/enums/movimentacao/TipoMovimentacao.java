package com.learning.api.minisys.enums.movimentacao;

public enum TipoMovimentacao {

    ENTRADA("Entrada"),
    SAIDA("Saída");

    private String descricao;

    TipoMovimentacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
