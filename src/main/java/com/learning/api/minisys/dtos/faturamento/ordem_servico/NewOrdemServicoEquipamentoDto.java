package com.learning.api.minisys.dtos.faturamento.ordem_servico;

public class NewOrdemServicoEquipamentoDto {

    private Long CODIGO;

    public NewOrdemServicoEquipamentoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
