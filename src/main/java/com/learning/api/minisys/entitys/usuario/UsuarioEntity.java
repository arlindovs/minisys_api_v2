package com.learning.api.minisys.entitys.usuario;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.dtos.usuario.UsuarioDto;
import com.learning.api.minisys.dtos.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(name = "GRUPO_USUARIO")
    @ManyToOne
    private UsuarioGrupoDto usuarioGrupo;

    @Column(name = "FUNCIONARIO")
    @ManyToOne
    private IntegranteDto funcionario;

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

        this.usuarioGrupo = dadosUsuario.usuarioGrupo();
        this.funcionario = dadosUsuario.funcionario();
        this.login = dadosUsuario.login();
        this.password = dadosUsuario.password();
        this.status = dadosUsuario.status();
        this.company = dadosUsuario.company();
        this.version = dadosUsuario.version();
    }

}
