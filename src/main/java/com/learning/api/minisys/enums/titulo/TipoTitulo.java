package com.learning.api.minisys.enums.titulo;

public enum TipoTitulo {

    PAGAR("Pagar"),
    RECEBER("Receber");

    private String descricao;

    TipoTitulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
