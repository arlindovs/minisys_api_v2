package com.learning.api.minisys.enums.item;

public enum OrigemItem {

    NACIONAL("Nacional"),
    IMPORTADO("Importado");

    private String descricao;

    OrigemItem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
