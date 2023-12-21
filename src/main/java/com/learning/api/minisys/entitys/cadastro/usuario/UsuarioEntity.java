package com.learning.api.minisys.entitys.cadastro.usuario;

import com.learning.api.minisys.dtos.cadastro.usuario.UsuarioDto;
import com.learning.api.minisys.dtos.cadastro.usuario.table.UsuarioTableDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

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
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;

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
        this.empresa = dadosUsuario.empresa();
        this.versao = LocalDateTime.now();
    }

    public UsuarioEntity(UsuarioTableDto usuarioTableDto) {
        this.CODIGO = usuarioTableDto.CODIGO();
        this.usuarioGrupo = new UsuarioGrupoEntity(usuarioTableDto.usuarioGrupo());
        this.funcionario = new IntegranteEntity(usuarioTableDto.funcionario());
        this.login = usuarioTableDto.login();
        this.status = usuarioTableDto.status();
        this.empresa = usuarioTableDto.empresa();
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
        if (dadosUsuario.empresa() != null) {
            this.empresa = dadosUsuario.empresa();
        }
        this.versao = LocalDateTime.now();
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
        if (this.usuarioGrupo.getPerfil().equals("ADMIN")) {
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

