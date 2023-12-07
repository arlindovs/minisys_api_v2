package com.learning.api.minisys.dtos.usuario;

import com.learning.api.minisys.entitys.usuario.UsuarioGrupoEntity;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UsuarioGrupoGuidDto(

        @NotBlank(message = "O campo guid é obrigatório")
        String guid
) {

    public UsuarioGrupoGuidDto(UsuarioGrupoEntity usuarioGrupoEntity) {
        this(usuarioGrupoEntity.getGuid());
    }

    public UsuarioGrupoGuidDto(UUID uuid) {
        this(uuid.toString());
    }
}
