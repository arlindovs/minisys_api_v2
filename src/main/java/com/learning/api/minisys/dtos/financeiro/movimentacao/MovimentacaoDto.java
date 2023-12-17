package com.learning.api.minisys.dtos.financeiro.movimentacao;

import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.dtos.financeiro.titulo.NewTituloDto;
import com.learning.api.minisys.dtos.financeiro.titulo.TituloDto;
import com.learning.api.minisys.entitys.financeiro.movimentacao.MovimentacaoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.movimentacao.StatusMovimentacao;
import com.learning.api.minisys.enums.movimentacao.Tipo;
import com.learning.api.minisys.enums.movimentacao.TipoMovimentacao;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MovimentacaoDto(

        Long CODIGO,
        @Enumerated
        StatusMovimentacao statusMovimentacao,
        @Enumerated
        Tipo tipo,
        @Enumerated
        TipoMovimentacao tipoMovimentacao,
        NewTituloDto titulo,
        String descricao,
        String observacao,
        NewIntegranteDto integrante,
        NewIntegranteDto funcionario,
        NewFormaPagamentoDto formaPagamento,
        LocalDateTime dataLancamento,
        LocalDateTime dataVencimento,
        LocalDateTime dataCompensacao,
        Double valor,
        Double valorDesconto,
        Double valorAcrescimo,
        Double total,
        Status status,
        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao
) {
    public MovimentacaoDto(MovimentacaoEntity movimentacaoEntity) {
        this(movimentacaoEntity.getCODIGO(),
                movimentacaoEntity.getStatusMovimentacao(),
                movimentacaoEntity.getTipo(),
                movimentacaoEntity.getTipoMovimentacao(),
                movimentacaoEntity.getTitulo() != null ?
                        new NewTituloDto(movimentacaoEntity.getTitulo().getCODIGO()) : null,
                movimentacaoEntity.getDescricao(),
                movimentacaoEntity.getObservacao(),
                movimentacaoEntity.getIntegrante() != null ?
                        new NewIntegranteDto(movimentacaoEntity.getIntegrante().getCODIGO()) : null,
                movimentacaoEntity.getFuncionario() != null ?
                        new NewIntegranteDto(movimentacaoEntity.getFuncionario().getCODIGO()) : null,
                movimentacaoEntity.getFormaPagamento() != null ?
                        new NewFormaPagamentoDto(movimentacaoEntity.getFormaPagamento().getCODIGO()) : null,
                movimentacaoEntity.getDataLancamento(),
                movimentacaoEntity.getDataVencimento(),
                movimentacaoEntity.getDataCompensacao(),
                movimentacaoEntity.getValor(),
                movimentacaoEntity.getValorDesconto(),
                movimentacaoEntity.getValorAcrescimo(),
                movimentacaoEntity.getTotal(),
                movimentacaoEntity.getStatus(),
                movimentacaoEntity.getEmpresa(),
                movimentacaoEntity.getVersao()
        );
    }
}
