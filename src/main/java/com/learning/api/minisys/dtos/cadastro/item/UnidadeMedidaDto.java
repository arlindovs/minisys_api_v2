package com.learning.api.minisys.dtos.cadastro.item;

import com.learning.api.minisys.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UnidadeMedidaDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,

        @NotBlank(message = "O campo simbolo é obrigatório")
        String simbolo,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao
) {

    public UnidadeMedidaDto(UnidadeMedidaEntity unidadeMedidaEntity) {
        this(unidadeMedidaEntity.getCODIGO(),
                unidadeMedidaEntity.getDescricao(),
                unidadeMedidaEntity.getSimbolo(),
                unidadeMedidaEntity.getStatus(),
                unidadeMedidaEntity.getEmpresa(),
                unidadeMedidaEntity.getVersao());
    }
}
