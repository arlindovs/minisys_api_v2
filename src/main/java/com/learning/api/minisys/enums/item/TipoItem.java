package com.learning.api.minisys.enums.item;

public enum TipoItem {

    PRODUTO("Produto"),
    SERVICO("Serviço");

    private String descricao;

    TipoItem(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return this.descricao;
    }
}
