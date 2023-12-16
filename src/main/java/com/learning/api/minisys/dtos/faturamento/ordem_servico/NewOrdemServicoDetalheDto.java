package com.learning.api.minisys.dtos.faturamento.ordem_servico;

public class NewOrdemServicoDetalheDto {

    private Long CODIGO;

    public NewOrdemServicoDetalheDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
