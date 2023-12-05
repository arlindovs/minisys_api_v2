package com.learning.api.minisys.dtos.usuario;

import com.learning.api.minisys.entitys.usuario.UsuarioGrupoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.usuario.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UsuarioGrupoDto(

        String guid,

        @NotBlank(message = "O campo descrição é obrigatório")
        String description,

        @Enumerated
        Role profile,

        @Enumerated
        Status status,

        @NotBlank(message = "O campo empresa é obrigatório")
        Long company,

        @NotBlank(message = "O campo versão é obrigatório")
        LocalDateTime version
) {

    public UsuarioGrupoDto(UsuarioGrupoEntity usuarioGrupoEntity) {
        this(usuarioGrupoEntity.getGuid(),
                usuarioGrupoEntity.getDescription(),
                usuarioGrupoEntity.getProfile(),
                usuarioGrupoEntity.getStatus(),
                usuarioGrupoEntity.getCompany(),
                usuarioGrupoEntity.getVersion());
    }
}
