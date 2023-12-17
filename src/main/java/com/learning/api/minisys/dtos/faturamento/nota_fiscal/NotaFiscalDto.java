package com.learning.api.minisys.dtos.faturamento.nota_fiscal;

import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.nota_fiscal.FinalidadeNotaFiscal;
import com.learning.api.minisys.enums.nota_fiscal.TipoNotaFiscal;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Blob;
import java.time.LocalDateTime;

public record NotaFiscalDto(
        Long CODIGO,
        @Enumerated
        TipoNotaFiscal tipo,
        @Enumerated
        FinalidadeNotaFiscal finalidade,
        Long numero,
        Long rds,
        String chaveAcesso,
        LocalDateTime dataEmissao,
        LocalDateTime dataEntradaSaida,
        LocalDateTime dataFatura,
        LocalDateTime dataReferenciaFiscal,
        LocalDateTime dataEnvio,
        LocalDateTime dataConfirmacao,
        NewIntegranteDto integrante,
        Double totalProduto,
        Double totalServico,
        Double totalDesconto,
        Double totalAcrescimo,
        Double total,
        Blob xml,
        @Enumerated
        Status status,
        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao
) {
    public NotaFiscalDto(NotaFiscalEntity notaFiscalEntity) {
        this(notaFiscalEntity.getCODIGO(),
                notaFiscalEntity.getTipo(),
                notaFiscalEntity.getFinalidade(),
                notaFiscalEntity.getNumero(),
                notaFiscalEntity.getRds(),
                notaFiscalEntity.getChaveAcesso(),
                notaFiscalEntity.getDataEmissao(),
                notaFiscalEntity.getDataEntradaSaida(),
                notaFiscalEntity.getDataFatura(),
                notaFiscalEntity.getDataReferenciaFiscal(),
                notaFiscalEntity.getDataEnvio(),
                notaFiscalEntity.getDataConfirmacao(),
                notaFiscalEntity.getIntegrante() != null ?
                        new NewIntegranteDto(notaFiscalEntity.getIntegrante().getCODIGO()) : null,
                notaFiscalEntity.getTotalProduto(),
                notaFiscalEntity.getTotalServico(),
                notaFiscalEntity.getTotalDesconto(),
                notaFiscalEntity.getTotalAcrescimo(),
                notaFiscalEntity.getTotal(),
                notaFiscalEntity.getXml(),
                notaFiscalEntity.getStatus(),
                notaFiscalEntity.getEmpresa(),
                notaFiscalEntity.getVersao());
    }
}
