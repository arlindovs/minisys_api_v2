package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.integrante.TipoDocumento;
import com.learning.api.minisys.repositories.integrante.IntegranteGrupoRepository;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record IntegranteDto(

        Long CODIGO,

        NewIntegranteGrupoDto integranteGrupo,

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
        this(integranteEntity.getCODIGO(),
                integranteEntity.getIntegranteGrupo() != null ?
                        new NewIntegranteGrupoDto(integranteEntity.getIntegranteGrupo().getCODIGO()) : null,
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
