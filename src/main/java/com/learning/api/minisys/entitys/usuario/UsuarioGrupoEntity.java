package com.learning.api.minisys.entitys.usuario;

import com.learning.api.minisys.dtos.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.usuario.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "usuario_grupo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGrupoEntity extends BaseEntity {

    @Column(name = "DESCRICAO")
    private String description;

    @Column(name = "PERFIL")
    @Enumerated(EnumType.STRING)
    private Role profile;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long company;

    @Column(name = "VERSAO")
    private LocalDateTime version;


    public UsuarioGrupoEntity(UsuarioGrupoDto usuarioGrupoDto) {
        super();

        this.description = usuarioGrupoDto.description();
        this.profile = usuarioGrupoDto.profile();
        this.status = usuarioGrupoDto.status();
        this.company = usuarioGrupoDto.company();
        this.version = LocalDateTime.now();
    }
}
