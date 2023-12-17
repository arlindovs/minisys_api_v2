package com.learning.api.minisys.dtos.financeiro.titulo;

import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.entitys.financeiro.titulo.TituloEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.titulo.StatusTitulo;
import com.learning.api.minisys.enums.titulo.TipoTitulo;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TituloDto(

        Long CODIGO,
        @Enumerated
        StatusTitulo statusTitulo,
        @Enumerated
        TipoTitulo tipo,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        String observacao,
        NewIntegranteDto integrante,
        NewIntegranteDto funcionario,
        LocalDateTime dataLancamento,
        LocalDateTime dataVencimento,
        LocalDateTime dataUltimoPagamento,
        Double valor,
        Double valorDesconto,
        Double valorAcrescimo,
        Double valorJuros,
        Double valorMulta,
        Double valorPago,
        Double valorEmAberto,
        Double total,
        @Enumerated
        Status status,
        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao

) {
    public TituloDto(TituloEntity tituloEntity) {
        this(tituloEntity.getCODIGO(),
                tituloEntity.getStatusTitulo(),
                tituloEntity.getTipo(),
                tituloEntity.getDescricao(),
                tituloEntity.getObservacao(),
                tituloEntity.getIntegrante() != null ?
                        new NewIntegranteDto(tituloEntity.getIntegrante().getCODIGO()) : null,
                tituloEntity.getFuncionario() != null ?
                        new NewIntegranteDto(tituloEntity.getFuncionario().getCODIGO()) : null,
                tituloEntity.getDataLancamento(),
                tituloEntity.getDataVencimento(),
                tituloEntity.getDataUltimoPagamento(),
                tituloEntity.getValor(),
                tituloEntity.getValorDesconto(),
                tituloEntity.getValorAcrescimo(),
                tituloEntity.getValorJuros(),
                tituloEntity.getValorMulta(),
                tituloEntity.getValorPago(),
                tituloEntity.getValorEmAberto(),
                tituloEntity.getTotal(),
                tituloEntity.getStatus(),
                tituloEntity.getEmpresa(),
                tituloEntity.getVersao()
        );
    }
}
