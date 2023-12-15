package com.learning.api.minisys.dtos.cadastro.integrante;

import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record IntegranteGrupoDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime version
) {

    public IntegranteGrupoDto(IntegranteGrupoEntity integranteGrupoEntity) {
        this(integranteGrupoEntity.getCODIGO(),
                integranteGrupoEntity.getDescricao(),
                integranteGrupoEntity.getStatus(),
                integranteGrupoEntity.getEmpresa(),
                integranteGrupoEntity.getVersao());
    }
}
