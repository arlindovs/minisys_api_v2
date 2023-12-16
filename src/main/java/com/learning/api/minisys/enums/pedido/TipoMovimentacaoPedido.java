package com.learning.api.minisys.enums.pedido;

public enum TipoMovimentacaoPedido {

    ENTREGUE("Entregue"),
    RETIRADO("Retirado"),
    ENVIADO("Enviado"),
    DEVOLVIDO("Devolvido"),
    PARCIAL("Parcial"),
    TRANSFERENCIA("Transferência"),
    OUTROS("Outros");

    private String descricao;

    TipoMovimentacaoPedido(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
