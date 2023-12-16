package com.learning.api.minisys.dtos.faturamento.nota_fiscal;

import com.learning.api.minisys.dtos.cadastro.item.NewItemDto;
import com.learning.api.minisys.dtos.cadastro.item.NewPerfilFiscalDto;
import com.learning.api.minisys.dtos.cadastro.item.NewUnidadeMedidaDto;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalDetalheEntity;
import com.learning.api.minisys.enums.item.TipoItem;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record NotaFiscalDetalheDto(

        Long CODIGO,
        NewNotaFiscalDto notaFiscal,
        NewPerfilFiscalDto perfilFiscal,
        Boolean cancelado,
        Long ordem,
        @Enumerated
        TipoItem tipoItem,
        NewItemDto item,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        NewUnidadeMedidaDto unidadeMedida,
        String ncm,
        String cest,
        @NotBlank(message = "O campo quantidade é obrigatório")
        Double quantidade,
        Double quantidadeDevolvida,
        @NotBlank(message = "O campo valor unitário é obrigatório")
        Double valorUnitario,
        Double valorDesconto,
        Double valorAcrescimo,
        Double valorTotal

) {

    public NotaFiscalDetalheDto(NotaFiscalDetalheEntity notaFiscalDetalheEntity) {
        this(notaFiscalDetalheEntity.getCODIGO(),
                notaFiscalDetalheEntity.getNotaFiscal() != null ?
                        new NewNotaFiscalDto(notaFiscalDetalheEntity.getNotaFiscal().getCODIGO()) : null,
                notaFiscalDetalheEntity.getPerfilFiscal() != null ?
                        new NewPerfilFiscalDto(notaFiscalDetalheEntity.getPerfilFiscal().getCODIGO()) : null,
                notaFiscalDetalheEntity.getCancelado(),
                notaFiscalDetalheEntity.getOrdem(),
                notaFiscalDetalheEntity.getTipoItem(),
                notaFiscalDetalheEntity.getItem() != null ?
                        new NewItemDto(notaFiscalDetalheEntity.getItem().getCODIGO()) : null,
                notaFiscalDetalheEntity.getDescricao(),
                notaFiscalDetalheEntity.getUnidadeMedida() != null ?
                        new NewUnidadeMedidaDto(notaFiscalDetalheEntity.getUnidadeMedida().getCODIGO()) : null,
                notaFiscalDetalheEntity.getNcm(),
                notaFiscalDetalheEntity.getCest(),
                notaFiscalDetalheEntity.getQuantidade(),
                notaFiscalDetalheEntity.getQuantidadeDevolvida(),
                notaFiscalDetalheEntity.getValorUnitario(),
                notaFiscalDetalheEntity.getValorDesconto(),
                notaFiscalDetalheEntity.getValorAcrescimo(),
                notaFiscalDetalheEntity.getValorTotal());
    }
}
