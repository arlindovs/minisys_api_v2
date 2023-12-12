package com.learning.api.minisys.dtos.usuario;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioDto(

        Long CODIGO,

        UsuarioGrupoDto usuarioGrupo,

        IntegranteDto funcionario,

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
        this(usuarioEntity.getCODIGO(),
                usuarioEntity.getUsuarioGrupo() != null ? new UsuarioGrupoDto(usuarioEntity.getUsuarioGrupo()) : null,
                usuarioEntity.getFuncionario() != null ? new IntegranteDto(usuarioEntity.getFuncionario()) : null,
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatus(),
                usuarioEntity.getCompany(),
                usuarioEntity.getVersion());
    }
}
