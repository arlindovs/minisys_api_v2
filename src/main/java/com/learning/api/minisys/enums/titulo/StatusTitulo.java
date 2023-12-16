package com.learning.api.minisys.enums.titulo;

public enum StatusTitulo {

    ABERTO("Aberto"),
    BAIXADO("Baixado"),
    BAIXADO_PARCIAL("Baixado Parcial");

    private String descricao;

    StatusTitulo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
