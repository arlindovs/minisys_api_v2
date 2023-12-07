package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.integrante.TipoDocumento;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record IntegranteDto(

        String guid,

        IntegranteGuidGrupoDto integranteGrupo,

        String name,

        String secondName,

        String fone,

        String email,

        TipoDocumento documentType,

        String document,

        LocalDateTime creationDate,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long company,

        LocalDateTime version
) {

    public IntegranteDto(IntegranteEntity integranteEntity) {
        this(integranteEntity.getGuid(),
                integranteEntity.getIntegranteGrupo() != null ? new IntegranteGuidGrupoDto(integranteEntity.getIntegranteGrupo()) : null,
                integranteEntity.getName(),
                integranteEntity.getSecondName(),
                integranteEntity.getFone(),
                integranteEntity.getEmail(),
                integranteEntity.getDocumentType(),
                integranteEntity.getDocument(),
                integranteEntity.getCreationDate(),
                integranteEntity.getStatus(),
                integranteEntity.getCompany(),
                integranteEntity.getVersion());
    }
}
