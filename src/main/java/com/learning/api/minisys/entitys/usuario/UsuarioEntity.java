package com.learning.api.minisys.entitys.usuario;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.dtos.usuario.UsuarioDto;
import com.learning.api.minisys.dtos.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity extends BaseEntity {

    @JoinColumn(name = "GRUPO_USUARIO")
    @ManyToOne
    private UsuarioGrupoEntity usuarioGrupo;

    @JoinColumn(name = "FUNCIONARIO")
    @ManyToOne
    private IntegranteEntity funcionario;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "STATUS")
    private Status status;

    @Column(name = "EMPRESA")
    private Long company;

    @Column(name = "VERSAO")
    private LocalDateTime version;


    public UsuarioEntity(UsuarioDto dadosUsuario) {
        super();

        new UsuarioGrupoEntity(dadosUsuario.usuarioGrupo());
        new IntegranteEntity(dadosUsuario.funcionario());
        this.login = dadosUsuario.login();
        this.password = dadosUsuario.password();
        this.status = dadosUsuario.status();
        this.company = dadosUsuario.company();
        this.version = LocalDateTime.now();
    }

}
