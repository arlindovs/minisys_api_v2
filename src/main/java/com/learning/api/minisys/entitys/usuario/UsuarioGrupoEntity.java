package com.learning.api.minisys.entitys.usuario;

import com.learning.api.minisys.dtos.usuario.NewUsuarioGrupoDto;
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

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @Column(name = "PERFIL")
    @Enumerated(EnumType.STRING)
    private Role perfil;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public UsuarioGrupoEntity(UsuarioGrupoDto usuarioGrupoDto) {
        this.descricao = usuarioGrupoDto.descricao();
        this.perfil = usuarioGrupoDto.perfil();
        this.status = usuarioGrupoDto.status();
        this.empresa = usuarioGrupoDto.empresa();
        this.versao = LocalDateTime.now();
    }

    public UsuarioGrupoEntity(NewUsuarioGrupoDto newUsuarioGrupoDto) {
        super();
    }

    public void atualizarUsuarioGrupo(UsuarioGrupoDto usuarioGrupoDto) {
        if(usuarioGrupoDto.descricao() != null) {
            this.descricao = usuarioGrupoDto.descricao();
        }
        if(usuarioGrupoDto.perfil() != null) {
            this.perfil = usuarioGrupoDto.perfil();
        }
        if(usuarioGrupoDto.status() != null) {
            this.status = usuarioGrupoDto.status();
        }
        if(usuarioGrupoDto.empresa() != null) {
            this.empresa = usuarioGrupoDto.empresa();
        }
        this.versao = LocalDateTime.now();
    }

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
    }
}
