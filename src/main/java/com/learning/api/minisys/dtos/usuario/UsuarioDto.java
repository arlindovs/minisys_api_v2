package com.learning.api.minisys.dtos.usuario;

import com.learning.api.minisys.dtos.integrante.NewIntegranteDto;
import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioDto(

        Long CODIGO,

        NewUsuarioGrupoDto usuarioGrupo,

        NewIntegranteDto funcionario,

        @NotBlank(message = "O campo nome é obrigatório")
        String login,

        @NotBlank(message = "O campo senha é obrigatório")
        String password,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa,

        LocalDateTime versao

) {

    public UsuarioDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getCODIGO(),
                new NewUsuarioGrupoDto(usuarioEntity.getUsuarioGrupo().getCODIGO()),
                new NewIntegranteDto(usuarioEntity.getFuncionario().getCODIGO()),
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatus(),
                usuarioEntity.getEmpresa(),
                usuarioEntity.getVersao());
    }
}
