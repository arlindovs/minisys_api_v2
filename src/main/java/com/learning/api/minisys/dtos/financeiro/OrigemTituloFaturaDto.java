package com.learning.api.minisys.dtos.financeiro;

import com.learning.api.minisys.dtos.faturamento.nota_fiscal.NewNotaFiscalDto;
import com.learning.api.minisys.dtos.faturamento.ordem_servico.NewOrdemServicoDto;
import com.learning.api.minisys.dtos.faturamento.pedido.NewPedidoDto;
import com.learning.api.minisys.dtos.financeiro.titulo.NewTituloDto;
import com.learning.api.minisys.entitys.financeiro.OrigemTituloFaturaEntity;

import java.time.LocalDateTime;

public record OrigemTituloFaturaDto(

        Long CODIGO,
        LocalDateTime dataCriacao,
        NewPedidoDto pedido,
        NewOrdemServicoDto ordemServico,
        NewNotaFiscalDto notaFiscal,
        NewTituloDto titulo
) {

    public OrigemTituloFaturaDto(OrigemTituloFaturaEntity origemTituloFaturaEntity){
        this(origemTituloFaturaEntity.getCODIGO(),
                origemTituloFaturaEntity.getDataCriacao(),
                origemTituloFaturaEntity.getPedido() != null ?
                        new NewPedidoDto(origemTituloFaturaEntity.getPedido().getCODIGO()) : null,
                origemTituloFaturaEntity.getOrdemServico() != null ?
                        new NewOrdemServicoDto(origemTituloFaturaEntity.getOrdemServico().getCODIGO()) : null,
                origemTituloFaturaEntity.getNotaFiscal() != null ?
                        new NewNotaFiscalDto(origemTituloFaturaEntity.getNotaFiscal().getCODIGO()) : null,
                origemTituloFaturaEntity.getTitulo() != null ?
                        new NewTituloDto(origemTituloFaturaEntity.getTitulo().getCODIGO()) : null
        );
    }
}
