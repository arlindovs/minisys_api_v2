package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;

import java.util.UUID;

public record IntegranteGuidGrupoDto(
        String guid
) {

    public IntegranteGuidGrupoDto(IntegranteGrupoEntity integranteGrupoEntity) {
        this(integranteGrupoEntity.getGuid());
    }

    public IntegranteGuidGrupoDto(UUID uuid) {
        this(uuid.toString());
    }
}
