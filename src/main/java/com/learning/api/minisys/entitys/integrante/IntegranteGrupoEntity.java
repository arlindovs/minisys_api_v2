package com.learning.api.minisys.entitys.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteGrupoDto;
import com.learning.api.minisys.dtos.integrante.IntegranteGuidGrupoDto;
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

    @Column(name = "DESCRICAO")
    private String description;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long company;

    @Column(name = "VERSAO")
    private LocalDateTime version;


    public IntegranteGrupoEntity(IntegranteGrupoDto integranteGrupoDto) {
        super();

        this.description = integranteGrupoDto.description();
        this.status = integranteGrupoDto.status();
        this.company = integranteGrupoDto.company();
        this.version = LocalDateTime.now();
    }

    public void atualizarIntegranteGrupo(IntegranteGrupoDto integranteGrupoDto) {
        if(integranteGrupoDto.description() != null) {
            this.description = integranteGrupoDto.description();
        }
        if(integranteGrupoDto.status() != null) {
            this.status = integranteGrupoDto.status();
        }
        if(integranteGrupoDto.company() != null) {
            this.company = integranteGrupoDto.company();
        }
        this.version = LocalDateTime.now();
    }

    public IntegranteGrupoEntity(IntegranteGuidGrupoDto integranteGuidGrupoDto) {
        super();
    }
}
