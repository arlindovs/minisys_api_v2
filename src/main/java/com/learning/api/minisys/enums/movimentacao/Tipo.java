package com.learning.api.minisys.enums.movimentacao;

public enum Tipo {

    CAIXA("Caixa"),
    BANCO("Banco");

    private String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
