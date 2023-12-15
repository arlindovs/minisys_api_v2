package com.learning.api.minisys.dtos.item;

import com.learning.api.minisys.entitys.item.PerfilFiscalEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record PerfilFiscalDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,

        @Enumerated
        Status status,

        @NotBlank(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao
) {

    public PerfilFiscalDto(PerfilFiscalEntity perfilFiscalEntity) {
        this(perfilFiscalEntity.getCODIGO(),
                perfilFiscalEntity.getDescricao(),
                perfilFiscalEntity.getStatus(),
                perfilFiscalEntity.getEmpresa(),
                perfilFiscalEntity.getVersao());
    }
}
