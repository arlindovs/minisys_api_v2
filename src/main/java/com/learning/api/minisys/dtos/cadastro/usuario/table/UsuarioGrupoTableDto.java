package com.learning.api.minisys.dtos.cadastro.usuario.table;

import com.learning.api.minisys.entitys.cadastro.usuario.UsuarioGrupoEntity;
import jakarta.validation.constraints.NotBlank;

public record UsuarioGrupoTableDto(

        Long CODIGO,

        @NotBlank(message = "O campo descrição é obrigatório")
        String descricao
) {

    public UsuarioGrupoTableDto(UsuarioGrupoEntity usuarioGrupoEntity) {
        this(usuarioGrupoEntity.getCODIGO(),
                usuarioGrupoEntity.getDescricao());
    }
}
