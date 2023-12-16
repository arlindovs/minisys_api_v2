package com.learning.api.minisys.enums.estoque;

public enum TipoEstoque {

    ENTRADA("Entrada"),
    SAIDA("Saída");

    private String descricao;

    TipoEstoque(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
