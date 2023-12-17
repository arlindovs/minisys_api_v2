package com.learning.api.minisys.dtos.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.ordem_servico.FinalidadeOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.StatusOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.TipoMovimentacaoOrdem;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrdemServicoDto(
        Long CODIGO,
        @Enumerated
        TipoMovimentacaoOrdem tipoMovimentacao,
        @Enumerated
        FinalidadeOrdemServico finalidade,
        @Enumerated
        StatusOrdemServico statusOrdem,
        Long numero,
        String controle,
        LocalDateTime dataEmissao,
        LocalDateTime dataEntrega,
        LocalDateTime dataFatura,
        LocalDateTime dataValidade,
        LocalDateTime dataPrevisao,
        LocalDateTime dataServicoInicio,
        LocalDateTime dataServicoFim,
        NewIntegranteDto integrante,
        Double totalProduto,
        Double totalServico,
        Double totalDesconto,
        Double totalAcrescimo,
        Double total,
        @Enumerated
        Status status,
        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao
) {
    public OrdemServicoDto(OrdemServicoEntity ordemServicoEntity) {
        this(ordemServicoEntity.getCODIGO(),
                ordemServicoEntity.getTipoMovimentacao(),
                ordemServicoEntity.getFinalidade(),
                ordemServicoEntity.getStatusOrdem(),
                ordemServicoEntity.getNumero(),
                ordemServicoEntity.getControle(),
                ordemServicoEntity.getDataEmissao(),
                ordemServicoEntity.getDataEntrega(),
                ordemServicoEntity.getDataFatura(),
                ordemServicoEntity.getDataValidade(),
                ordemServicoEntity.getDataPrevisao(),
                ordemServicoEntity.getDataServicoInicio(),
                ordemServicoEntity.getDataServicoFim(),
                ordemServicoEntity.getIntegrante() != null ?
                        new NewIntegranteDto(ordemServicoEntity.getIntegrante().getCODIGO()) : null,
                ordemServicoEntity.getTotalProduto(),
                ordemServicoEntity.getTotalServico(),
                ordemServicoEntity.getTotalDesconto(),
                ordemServicoEntity.getTotalAcrescimo(),
                ordemServicoEntity.getTotal(),
                ordemServicoEntity.getStatus(),
                ordemServicoEntity.getEmpresa(),
                ordemServicoEntity.getVersao());
    }
}
