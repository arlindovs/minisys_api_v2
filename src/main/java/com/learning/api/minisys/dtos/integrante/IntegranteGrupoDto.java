package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record IntegranteGrupoDto(

        String guid,

        @NotBlank(message = "O campo descrição é obrigatório")
        String description,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long company,

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
