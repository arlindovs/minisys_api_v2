package com.learning.api.minisys.dtos.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.cadastro.item.NewItemDto;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoEquipamentoEntity;
import com.learning.api.minisys.enums.item.TipoMovimentacaoItem;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record OrdemServicoEqipamentoDto(
        Long CODIGO,
        NewOrdemServicoDto ordemServico,
        @Enumerated
        TipoMovimentacaoItem tipoItem,
        NewItemDto item,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        @NotBlank(message = "O campo observação é obrigatório")
        String observacao,
        @NotBlank(message = "O campo número de série é obrigatório")
        String numeroSerie,
        @NotBlank(message = "O campo quantidade é obrigatório")
        Double quantidade
) {
    public OrdemServicoEqipamentoDto(OrdemServicoEquipamentoEntity ordemServicoEquipamentoEntity) {
        this(ordemServicoEquipamentoEntity.getCODIGO(),
                ordemServicoEquipamentoEntity.getOrdemServico() != null ?
                        new NewOrdemServicoDto(ordemServicoEquipamentoEntity.getOrdemServico().getCODIGO()) : null,
                ordemServicoEquipamentoEntity.getTipoItem(),
                ordemServicoEquipamentoEntity.getItem() != null ?
                        new NewItemDto(ordemServicoEquipamentoEntity.getItem().getCODIGO()) : null,
                ordemServicoEquipamentoEntity.getDescricao(),
                ordemServicoEquipamentoEntity.getObservacao(),
                ordemServicoEquipamentoEntity.getNumeroSerie(),
                ordemServicoEquipamentoEntity.getQuantidade());
    }
}
