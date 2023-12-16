package com.learning.api.minisys.dtos.faturamento.pedido;

public class NewPedidoDto {

    private Long CODIGO;

    public NewPedidoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
