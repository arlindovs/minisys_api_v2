package com.learning.api.minisys.entitys.usuario;

import com.learning.api.minisys.dtos.UsuarioDto;
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

import java.util.UUID;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity extends BaseEntity {

    @Column(name = "NOME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "PERFIL")
    @Enumerated(EnumType.STRING)
    private Role role;


    public UsuarioEntity(UsuarioDto dadosUsuario) {
        super();

        this.name = dadosUsuario.name();
        this.email = dadosUsuario.email();
        this.password = dadosUsuario.password();
        this.role = dadosUsuario.role();
    }

}
