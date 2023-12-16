package com.learning.api.minisys.enums.ordem_servico;

public enum FinalidadeOrdemServico {

    NORMAL("Normal"),
    BRINDE("Brinde"),
    AMOSTRA("Amostra"),
    GARANTIA("Garantia"),
    TROCA("Troca"),
    DEVOLUCAO("Devolução"),
    REPARO("Reparo"),
    REPOSICAO("Reposição"),
    CANCELAMENTO("Cancelamento"),
    OUTROS("Outros");

    private String descricao;

    FinalidadeOrdemServico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
