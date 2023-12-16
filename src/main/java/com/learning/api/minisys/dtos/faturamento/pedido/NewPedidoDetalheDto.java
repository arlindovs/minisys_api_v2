package com.learning.api.minisys.dtos.faturamento.pedido;

public class NewPedidoDetalheDto {

    private Long CODIGO;

    public NewPedidoDetalheDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
