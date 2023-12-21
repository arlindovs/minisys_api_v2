package com.learning.api.minisys.dtos.cadastro.usuario.table;

import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteDto;
import com.learning.api.minisys.dtos.cadastro.integrante.table.IntegranteTableDto;
import com.learning.api.minisys.dtos.cadastro.usuario.NewUsuarioGrupoDto;
import com.learning.api.minisys.entitys.cadastro.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UsuarioTableDto(

        Long CODIGO,

        UsuarioGrupoTableDto usuarioGrupo,

        IntegranteTableDto funcionario,

        @NotBlank(message = "O campo nome é obrigatório")
        String login,

        @Enumerated
        Status status,

        @NotNull(message = "O campo empresa é obrigatório")
        Long empresa
) {

    public UsuarioTableDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getCODIGO(),
                new UsuarioGrupoTableDto(usuarioEntity.getUsuarioGrupo()),
                new IntegranteTableDto(usuarioEntity.getFuncionario()),
                usuarioEntity.getLogin(),
                usuarioEntity.getStatus(),
                usuarioEntity.getEmpresa());
    }
}
