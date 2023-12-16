package com.learning.api.minisys.dtos.faturamento.ordem_servico;

public class NewOrdemServicoDto {

    private Long CODIGO;

    public NewOrdemServicoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
