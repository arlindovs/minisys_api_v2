package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record IntegranteGrupoDto(

        String guid,

        @NotBlank(message = "O campo descrição é obrigatório")
        String description,

        @Enumerated
        Status status,

        @NotBlank(message = "O campo empresa é obrigatório")
        Long company,

        @NotBlank(message = "O campo versão é obrigatório")
        LocalDateTime version
) {

    public IntegranteGrupoDto(IntegranteGrupoEntity integranteGrupoEntity) {
        this(integranteGrupoEntity.getGuid(),
                integranteGrupoEntity.getDescription(),
                integranteGrupoEntity.getStatus(),
                integranteGrupoEntity.getCompany(),
                integranteGrupoEntity.getVersion());
    }
}
