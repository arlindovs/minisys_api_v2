package com.learning.api.minisys.dtos.usuario;

public class NewUsuarioGrupoDto {

    private Long CODIGO;

    public NewUsuarioGrupoDto(Long CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Long getCODIGO() {
        return CODIGO;
    }
}
