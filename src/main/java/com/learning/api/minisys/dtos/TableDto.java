package com.learning.api.minisys.dtos;

import com.learning.api.minisys.entitys.usuario.UsuarioEntity;

public record TableDto(
        String guid,
        String name
) {

    public TableDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getGuid(),
                usuarioEntity.getName());
    }
}
