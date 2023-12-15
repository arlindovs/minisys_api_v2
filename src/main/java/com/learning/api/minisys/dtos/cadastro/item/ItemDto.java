package com.learning.api.minisys.dtos.cadastro.item;

import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.item.OrigemItem;
import com.learning.api.minisys.enums.item.TipoItem;
import com.learning.api.minisys.enums.item.TipoMovimentacaoItem;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ItemDto(

        Long CODIGO,
        LocalDateTime dataCadastro,
        @Enumerated
        TipoItem tipo,
        NewPerfilFiscalDto perfilFiscal,
        NewItemGrupoDto grupoItem,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        String observacao,
        NewUnidadeMedidaDto unidadeVenda,
        NewUnidadeMedidaDto unidadeCompra,
        Double unidadeCompraFator,
        NewFabricanteDto fabricante,
        @Enumerated
        OrigemItem origem,
        String ncm,
        String cest,
        String codigoBarras,
        String codigoOriginal,
        @Enumerated
        TipoMovimentacaoItem tipoMovimentacao,
        Double precoCusto,
        Double precoVenda,
        Double margemLucro,
        Double precoMinimo,
        Double estoqueDisponivel,
        Double estoqueFisico,
        Boolean controlaEstoque,
        Boolean podeAlterarPreco,
        Boolean podeAlterarDescricao,
        @Enumerated
        Status status,
        @NotBlank(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao
) {

    public ItemDto(ItemEntity itemEntity) {
        this(itemEntity.getCODIGO(),
                itemEntity.getDataCadastro(),
                itemEntity.getTipo(),
                itemEntity.getPerfilFiscal() != null ?
                        new NewPerfilFiscalDto(itemEntity.getPerfilFiscal().getCODIGO()) : null,
                itemEntity.getGrupoItem() != null ?
                        new NewItemGrupoDto(itemEntity.getGrupoItem().getCODIGO()) : null,
                itemEntity.getDescricao(),
                itemEntity.getObservacao(),
                itemEntity.getUnidadeVenda() != null ?
                        new NewUnidadeMedidaDto(itemEntity.getUnidadeVenda().getCODIGO()) : null,
                itemEntity.getUnidadeCompra() != null ?
                        new NewUnidadeMedidaDto(itemEntity.getUnidadeCompra().getCODIGO()) : null,
                itemEntity.getUnidadeCompraFator(),
                itemEntity.getFabricante() != null ?
                        new NewFabricanteDto(itemEntity.getFabricante().getCODIGO()) : null,
                itemEntity.getOrigem(),
                itemEntity.getNcm(),
                itemEntity.getCest(),
                itemEntity.getCodigoBarras(),
                itemEntity.getCodigoOriginal(),
                itemEntity.getTipoMovimentacao(),
                itemEntity.getPrecoCusto(),
                itemEntity.getPrecoVenda(),
                itemEntity.getMargemLucro(),
                itemEntity.getPrecoMinimo(),
                itemEntity.getEstoqueDisponivel(),
                itemEntity.getEstoqueFisico(),
                itemEntity.getControlaEstoque(),
                itemEntity.getPodeAlterarPreco(),
                itemEntity.getPodeAlterarDescricao(),
                itemEntity.getStatus(),
                itemEntity.getEmpresa(),
                itemEntity.getVersao());
    }
}
