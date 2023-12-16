package com.learning.api.minisys.enums.nota_fiscal;

public enum FinalidadeNotaFiscal {

    NORMAL("Normal"),
    COMPLEMENTAR("Complementar"),
    AJUSTE("Ajuste"),
    DEVOLUCAO("Devolução"),
    TRANSFERENCIA("Transferência"),
    ESTORNO("Estorno"),
    SUBSTITUICAO("Substituição"),
    ESTOQUE("Estoque");

    private String descricao;

    FinalidadeNotaFiscal(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
