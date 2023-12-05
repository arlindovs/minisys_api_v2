package com.learning.api.minisys.dtos.usuario;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record UsuarioDto(

        String guid,

        @NotBlank(message = "O campo grupo é obrigatório")
        UsuarioGrupoDto usuarioGrupo,

        @NotBlank(message = "O campo funcionário é obrigatório")
        IntegranteDto funcionario,

        @NotBlank(message = "O campo nome é obrigatório")
        String login,

        @NotBlank(message = "O campo senha é obrigatório")
        String password,

        @NotBlank(message = "O campo status é obrigatório")
        Status status,

        @NotBlank(message = "O campo empresa é obrigatório")
        Long company,

        @NotBlank(message = "O campo versão é obrigatório")
        LocalDateTime version

) {

    public UsuarioDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getGuid(),
                usuarioEntity.getUsuarioGrupo(),
                usuarioEntity.getFuncionario(),
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.getStatus(),
                usuarioEntity.getCompany(),
                usuarioEntity.getVersion());
    }
}
