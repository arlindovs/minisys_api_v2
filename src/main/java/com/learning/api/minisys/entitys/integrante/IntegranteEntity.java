package com.learning.api.minisys.entitys.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.integrante.TipoDocumento;
import com.learning.api.minisys.repositories.integrante.IntegranteGrupoRepository;
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

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "integrante")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteEntity extends BaseEntity {

    @JoinColumn(name = "GRUPO_INTEGRANTE")
    @ManyToOne
    private IntegranteGrupoEntity integranteGrupo;

    @Column(name = "NOME")
    private String name;

    @Column(name = "SEGUNDO_NOME")
    private String secondName;

    @Column(name = "TELEFONE")
    private String fone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TIPO_DOCUMENTO")
    @Enumerated(EnumType.STRING)
    private TipoDocumento documentType;

    @Column(name = "DOCUMENTO", unique = true)
    private String document;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime creationDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long company;

    @Column(name = "VERSAO")
    private LocalDateTime version;


    public IntegranteEntity(IntegranteDto dadosIntegrante) {
        if (dadosIntegrante.integranteGrupo() != null) {
            this.integranteGrupo = new IntegranteGrupoEntity(dadosIntegrante.integranteGrupo());
        }
        this.name = dadosIntegrante.name();
        this.secondName = dadosIntegrante.secondName();
        this.fone = dadosIntegrante.fone();
        this.email = dadosIntegrante.email();
        this.documentType = dadosIntegrante.documentType();
        this.document = dadosIntegrante.document();
        this.creationDate = LocalDateTime.now();
        this.status = dadosIntegrante.status();
        this.company = dadosIntegrante.company();
        this.version = LocalDateTime.now();
    }

    public void atualizarIntegrante(IntegranteDto dadosIntegrante) {
        if (dadosIntegrante.integranteGrupo() != null) {
            this.integranteGrupo = new IntegranteGrupoEntity(dadosIntegrante.integranteGrupo());
        }
        if (dadosIntegrante.name() != null) {
            this.name = dadosIntegrante.name();
        }
        if (dadosIntegrante.secondName() != null) {
            this.secondName = dadosIntegrante.secondName();
        }
        if (dadosIntegrante.fone() != null) {
            this.fone = dadosIntegrante.fone();
        }
        if (dadosIntegrante.email() != null) {
            this.email = dadosIntegrante.email();
        }
        if (dadosIntegrante.documentType() != null) {
            this.documentType = dadosIntegrante.documentType();
        }
        if (dadosIntegrante.document() != null) {
            this.document = dadosIntegrante.document();
        }
        if (dadosIntegrante.status() != null) {
            this.status = dadosIntegrante.status();
        }
        if (dadosIntegrante.company() != null) {
            this.company = dadosIntegrante.company();
        }
        this.version = LocalDateTime.now();
    }
}
