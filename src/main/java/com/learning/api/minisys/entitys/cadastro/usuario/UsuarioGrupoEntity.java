package com.learning.api.minisys.entitys.cadastro.usuario;

import com.learning.api.minisys.dtos.cadastro.usuario.NewUsuarioGrupoDto;
import com.learning.api.minisys.dtos.cadastro.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.usuario.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_grupo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGrupoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

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

    public UsuarioGrupoEntity(NewUsuarioGrupoDto newUsuarioGrupoDto) {}

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
