package com.learning.api.minisys.dtos.faturamento.pedido;

import com.learning.api.minisys.dtos.cadastro.item.NewItemDto;
import com.learning.api.minisys.dtos.cadastro.item.NewUnidadeMedidaDto;
import com.learning.api.minisys.entitys.faturamento.pedido.PedidoDetalheEntity;
import jakarta.validation.constraints.NotBlank;

public record PedidoDetalheDto(

        Long CODIGO,
        NewPedidoDto pedido,
        NewItemDto item,
        Boolean cancelado,
        Long ordem,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        NewUnidadeMedidaDto unidadeMedida,
        Double quantidade,
        Double quantidadeDevolvida,
        Double quantidadeFaturada,
        Double quantidadeEntregue,
        Double valorUnitario,
        Double valorDesconto,
        Double valorAcrescimo,
        Double valorTotal
) {

    public PedidoDetalheDto(PedidoDetalheEntity pedidoDetalheEntity) {
        this(pedidoDetalheEntity.getCODIGO(),
                pedidoDetalheEntity.getPedido() != null ?
                        new NewPedidoDto(pedidoDetalheEntity.getPedido().getCODIGO()) : null,
                pedidoDetalheEntity.getItem() != null ?
                        new NewItemDto(pedidoDetalheEntity.getItem().getCODIGO()) : null,
                pedidoDetalheEntity.getCancelado(),
                pedidoDetalheEntity.getOrdem(),
                pedidoDetalheEntity.getDescricao(),
                pedidoDetalheEntity.getUnidadeMedida() != null ?
                        new NewUnidadeMedidaDto(pedidoDetalheEntity.getUnidadeMedida().getCODIGO()) : null,
                pedidoDetalheEntity.getQuantidade(),
                pedidoDetalheEntity.getQuantidadeDevolvida(),
                pedidoDetalheEntity.getQuantidadeFaturada(),
                pedidoDetalheEntity.getQuantidadeEntregue(),
                pedidoDetalheEntity.getValorUnitario(),
                pedidoDetalheEntity.getValorDesconto(),
                pedidoDetalheEntity.getValorAcrescimo(),
                pedidoDetalheEntity.getValorTotal());
    }
}
