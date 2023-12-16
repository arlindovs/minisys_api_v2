package com.learning.api.minisys.enums.ordem_servico;

public enum TipoMovimentacaoOrdem {

    ENTREGE("Entregue"),
    RETIRADO("Retirado"),
    PARCIAL("Parcial");

    private String descricao;

    TipoMovimentacaoOrdem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
