package com.learning.api.minisys.dtos.cadastro.usuario;

import com.learning.api.minisys.entitys.cadastro.usuario.UsuarioGrupoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.usuario.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioGrupoDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao,

        @Enumerated
        Role perfil,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao
) {

    public UsuarioGrupoDto(UsuarioGrupoEntity usuarioGrupoEntity) {
        this(usuarioGrupoEntity.getCODIGO(),
                usuarioGrupoEntity.getDescricao(),
                usuarioGrupoEntity.getPerfil(),
                usuarioGrupoEntity.getStatus(),
                usuarioGrupoEntity.getEmpresa(),
                usuarioGrupoEntity.getVersao());
    }
}
