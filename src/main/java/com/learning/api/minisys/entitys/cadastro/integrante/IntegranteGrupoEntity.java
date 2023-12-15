package com.learning.api.minisys.entitys.cadastro.integrante;

import com.learning.api.minisys.dtos.cadastro.integrante.IntegranteGrupoDto;
import com.learning.api.minisys.dtos.cadastro.integrante.NewIntegranteGrupoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.Status;
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
@Table(name = "integrante_grupo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteGrupoEntity extends BaseEntity {

    @Column(name = "DESCRICAO", unique = true)
    private String descricao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public IntegranteGrupoEntity(IntegranteGrupoDto integranteGrupoDto) {
        this.descricao = integranteGrupoDto.descricao();
        this.status = integranteGrupoDto.status();
        this.empresa = integranteGrupoDto.empresa();
        this.versao = LocalDateTime.now();
    }

    public IntegranteGrupoEntity(NewIntegranteGrupoDto newIntegranteGrupoDto) {
        super();
    }

    public void atualizarIntegranteGrupo(IntegranteGrupoDto integranteGrupoDto) {
        if(integranteGrupoDto.descricao() != null) {
            this.descricao = integranteGrupoDto.descricao();
        }
        if(integranteGrupoDto.status() != null) {
            this.status = integranteGrupoDto.status();
        }
        if(integranteGrupoDto.empresa() != null) {
            this.empresa = integranteGrupoDto.empresa();
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
