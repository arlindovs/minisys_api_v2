package com.learning.api.minisys.dtos.usuario;

import com.learning.api.minisys.dtos.integrante.IntegranteGuidDto;
import com.learning.api.minisys.dtos.usuario.UsuarioGrupoGuidDto;
import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioDto(

        String guid,
        
        UsuarioGrupoGuidDto usuarioGrupo,

        IntegranteGuidDto funcionario,

        @NotBlank(message = "O campo nome é obrigatório")
        String login,

        @NotBlank(message = "O campo senha é obrigatório")
        String password,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long company,

        LocalDateTime version

) {

    public UsuarioDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getGuid(),
                new UsuarioGrupoGuidDto(usuarioEntity.getUsuarioGrupo()),
                new IntegranteGuidDto(usuarioEntity.getFuncionario()),
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatus(),
                usuarioEntity.getCompany(),
                usuarioEntity.getVersion());
    }
}
