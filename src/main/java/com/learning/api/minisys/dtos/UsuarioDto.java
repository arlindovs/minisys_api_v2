package com.learning.api.minisys.dtos;

import com.learning.api.minisys.entitys.usuario.UsuarioEntity;
import com.learning.api.minisys.enums.usuario.Role;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UsuarioDto(

        String guid,

        @NotBlank(message = "O campo nome é obrigatório")
        String name,

        @NotBlank(message = "O campo email é obrigatório")
        String email,

        @NotBlank(message = "O campo senha é obrigatório")
        String password,

        @Enumerated
        Role role
) {

    public UsuarioDto(UsuarioEntity usuarioEntity) {
        this(usuarioEntity.getGuid(),
                usuarioEntity.getName(),
                usuarioEntity.getEmail(),
                usuarioEntity.getPassword(),
                usuarioEntity.getRole());
    }
}
