package com.learning.api.minisys.dtos.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.cadastro.item.NewItemDto;
import com.learning.api.minisys.dtos.cadastro.item.NewUnidadeMedidaDto;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoDetalheEntity;
import com.learning.api.minisys.enums.item.TipoItem;
import jakarta.validation.constraints.NotBlank;

public record OrdemServicoDetalheDto(
        Long CODIGO,
        NewOrdemServicoDto ordemServico,
        TipoItem tipoItem,
        NewItemDto item,
        Boolean cancelado,
        Long ordem,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        NewUnidadeMedidaDto unidadeMedida,
        Double quantidade,
        Double quantidadeDevolvida,
        Double quantidadeFaturada,
        Double valorUnitario,
        Double valorDesconto,
        Double valorAcrescimo,
        Double valorTotal
) {

    public OrdemServicoDetalheDto(OrdemServicoDetalheEntity ordemServicoDetalheEntity) {
        this(ordemServicoDetalheEntity.getCODIGO(),
                ordemServicoDetalheEntity.getOrdemServico() != null ?
                        new NewOrdemServicoDto(ordemServicoDetalheEntity.getOrdemServico().getCODIGO()) : null,
                ordemServicoDetalheEntity.getTipoItem(),
                ordemServicoDetalheEntity.getItem() != null ?
                        new NewItemDto(ordemServicoDetalheEntity.getItem().getCODIGO()) : null,
                ordemServicoDetalheEntity.getCancelado(),
                ordemServicoDetalheEntity.getOrdem(),
                ordemServicoDetalheEntity.getDescricao(),
                ordemServicoDetalheEntity.getUnidadeMedida() != null ?
                        new NewUnidadeMedidaDto(ordemServicoDetalheEntity.getUnidadeMedida().getCODIGO()) : null,
                ordemServicoDetalheEntity.getQuantidade(),
                ordemServicoDetalheEntity.getQuantidadeDevolvida(),
                ordemServicoDetalheEntity.getQuantidadeFaturada(),
                ordemServicoDetalheEntity.getValorUnitario(),
                ordemServicoDetalheEntity.getValorDesconto(),
                ordemServicoDetalheEntity.getValorAcrescimo(),
                ordemServicoDetalheEntity.getValorTotal());
    }
}
