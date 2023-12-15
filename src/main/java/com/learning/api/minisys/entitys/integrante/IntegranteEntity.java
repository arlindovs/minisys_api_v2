package com.learning.api.minisys.entitys.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.dtos.integrante.NewIntegranteDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.integrante.TipoDocumento;
import com.learning.api.minisys.enums.integrante.TipoIntegrante;
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

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    TipoIntegrante tipoIntegrante;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SEGUNDO_NOME")
    private String segundoNome;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TIPO_DOCUMENTO")
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "DOCUMENTO", unique = true)
    private String documento;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public IntegranteEntity(IntegranteDto dadosIntegrante) {
        if (dadosIntegrante.integranteGrupo() != null) {
            this.integranteGrupo = new IntegranteGrupoEntity(dadosIntegrante.integranteGrupo());
        }
        this.tipoIntegrante = dadosIntegrante.tipoIntegrante();
        this.nome = dadosIntegrante.nome();
        this.segundoNome = dadosIntegrante.segundoNome();
        this.telefone = dadosIntegrante.telefone();
        this.email = dadosIntegrante.email();
        this.tipoDocumento = dadosIntegrante.tipoDocumento();
        this.documento = dadosIntegrante.documento();
        this.dataCriacao = LocalDateTime.now();
        this.status = dadosIntegrante.status();
        this.empresa = dadosIntegrante.empresa();
        this.versao = LocalDateTime.now();
    }

    public IntegranteEntity(NewIntegranteDto integrante) {
        super();
    }

    public void atualizarIntegrante(IntegranteDto dadosIntegrante) {
        if (dadosIntegrante.integranteGrupo() != null) {
            this.integranteGrupo = new IntegranteGrupoEntity(dadosIntegrante.integranteGrupo());
        }
        if(dadosIntegrante.tipoIntegrante() != null) {
            this.tipoIntegrante = dadosIntegrante.tipoIntegrante();
        }
        if (dadosIntegrante.nome() != null) {
            this.nome = dadosIntegrante.nome();
        }
        if (dadosIntegrante.segundoNome() != null) {
            this.segundoNome = dadosIntegrante.segundoNome();
        }
        if (dadosIntegrante.telefone() != null) {
            this.telefone = dadosIntegrante.telefone();
        }
        if (dadosIntegrante.email() != null) {
            this.email = dadosIntegrante.email();
        }
        if (dadosIntegrante.tipoDocumento() != null) {
            this.tipoDocumento = dadosIntegrante.tipoDocumento();
        }
        if (dadosIntegrante.documento() != null) {
            this.documento = dadosIntegrante.documento();
        }
        if (dadosIntegrante.status() != null) {
            this.status = dadosIntegrante.status();
        }
        if (dadosIntegrante.empresa() != null) {
            this.empresa = dadosIntegrante.empresa();
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
