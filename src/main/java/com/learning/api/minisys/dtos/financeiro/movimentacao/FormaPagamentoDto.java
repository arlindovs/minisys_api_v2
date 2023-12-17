package com.learning.api.minisys.dtos.financeiro.movimentacao;

import com.learning.api.minisys.entitys.financeiro.movimentacao.FormaPagamentoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.movimentacao.TipoFormaPagamento;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record FormaPagamentoDto(

        Long CODIGO,
        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,
        @Enumerated
        TipoFormaPagamento tipo,
        @Enumerated
        Status status,
        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,
        LocalDateTime versao
) {

    public FormaPagamentoDto(FormaPagamentoEntity formaPagamentoEntity) {
        this(formaPagamentoEntity.getCODIGO(),
                formaPagamentoEntity.getDescricao(),
                formaPagamentoEntity.getTipo(),
                formaPagamentoEntity.getStatus(),
                formaPagamentoEntity.getEmpresa(),
                formaPagamentoEntity.getVersao());
    }
}
