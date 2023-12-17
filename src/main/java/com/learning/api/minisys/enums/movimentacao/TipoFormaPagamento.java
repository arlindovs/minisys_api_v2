package com.learning.api.minisys.enums.movimentacao;

public enum TipoFormaPagamento {

    DINHEIRO("Dinheiro"),
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    CHEQUE("Cheque"),
    BOLETO("Boleto"),
    TRANSFERENCIA("Transferência"),
    DEPOSITO("Depósito"),
    PIX("Pix"),
    OUTROS("Outros");

    private String descricao;

    TipoFormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
