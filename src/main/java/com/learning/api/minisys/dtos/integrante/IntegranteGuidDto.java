package com.learning.api.minisys.dtos.integrante;

import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record IntegranteGuidDto(

        @NotBlank(message = "O campo guid é obrigatório")
        String guid
) {

        public IntegranteGuidDto(IntegranteEntity integranteEntity) {
                this(integranteEntity.getGuid());
        }

        public IntegranteGuidDto(UUID uuid) {
                this(uuid.toString());
        }
}
