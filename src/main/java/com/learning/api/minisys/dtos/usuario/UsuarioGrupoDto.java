package com.learning.api.minisys.dtos.usuario;

import com.learning.api.minisys.entitys.usuario.UsuarioGrupoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.usuario.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioGrupoDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String description,

        @Enumerated
        Role profile,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long company,

        LocalDateTime version
) {

    public UsuarioGrupoDto(UsuarioGrupoEntity usuarioGrupoEntity) {
        this(usuarioGrupoEntity.getCODIGO(),
                usuarioGrupoEntity.getDescription(),
                usuarioGrupoEntity.getProfile(),
                usuarioGrupoEntity.getStatus(),
                usuarioGrupoEntity.getCompany(),
                usuarioGrupoEntity.getVersion());
    }
}
