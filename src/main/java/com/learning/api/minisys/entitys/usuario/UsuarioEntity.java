package com.learning.api.minisys.entitys.usuario;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.dtos.usuario.UsuarioDto;
import com.learning.api.minisys.dtos.usuario.UsuarioGrupoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity extends BaseEntity implements UserDetails {

    @JoinColumn(name = "GRUPO_USUARIO")
    @ManyToOne
    private UsuarioGrupoEntity usuarioGrupo;

    @JoinColumn(name = "FUNCIONARIO")
    @ManyToOne
    private IntegranteEntity funcionario;

    @Column(name = "LOGIN", unique = true)
    private String login;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long company;

    @Column(name = "VERSAO")
    private LocalDateTime version;

    public UsuarioEntity(UsuarioDto dadosUsuario) {
        if (dadosUsuario.usuarioGrupo() != null) {
            this.usuarioGrupo = new UsuarioGrupoEntity(dadosUsuario.usuarioGrupo());
        }
        if (dadosUsuario.funcionario() != null) {
            this.funcionario = new IntegranteEntity(dadosUsuario.funcionario());
        }
        this.login = dadosUsuario.login();
        this.password = new BCryptPasswordEncoder().encode(dadosUsuario.password());
        this.status = dadosUsuario.status();
        this.company = dadosUsuario.company();
        this.version = LocalDateTime.now();
    }

    public void atualizarUsuario(UsuarioDto dadosUsuario) {
        if (dadosUsuario.usuarioGrupo() != null) {
            this.usuarioGrupo = new UsuarioGrupoEntity(dadosUsuario.usuarioGrupo());
        }
        if (dadosUsuario.funcionario() != null) {
            this.funcionario = new IntegranteEntity(dadosUsuario.funcionario());
        }
        if (dadosUsuario.login() != null) {
            this.login = dadosUsuario.login();
        }
        if (dadosUsuario.password() != null) {
            this.password = new BCryptPasswordEncoder().encode(dadosUsuario.password());
        }
        if (dadosUsuario.status() != null) {
            this.status = dadosUsuario.status();
        }
        if (dadosUsuario.company() != null) {
            this.company = dadosUsuario.company();
        }
        this.version = LocalDateTime.now();
    }

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
    }



//    Metodos do UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Verifica se o usuário pertence ao grupo de perfil "ADMIN"
        if (this.usuarioGrupo.getProfile().equals("ADMIN")) {
            // Se pertencer, concede as autoridades ROLE_ADMIN e ROLE_USER
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            // Se não pertencer, concede a autoridade ROLE_USER
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }


    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

