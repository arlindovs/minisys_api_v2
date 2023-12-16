package com.learning.api.minisys.enums.pedido;

public enum StatusPedido {

    PEDIDO("Pedido"),
    ORCAMENTO("Orçamento"),
    FATURADO("Faturado"),
    CONDICIONAL("Condicional"),
    COTACAO("Cotação"),
    CONCLUIDO("Concluído"),
    FINALIZADO("Finalizado");


    private String status;

    StatusPedido(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
