package com.learning.api.minisys.entitys.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteEnderecoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.integrante.TipoEndereco;
import com.learning.api.minisys.enums.integrante.TipoLogradouro;
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
@Table(name = "integrante_endereco")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntegranteEnderecoEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "INTEGRANTE")
    private IntegranteEntity integrante;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipo;

    @Column(name = "INSCRICAO_ESTADUAL")
    private String inscricaoEstadual;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "TIPO_LOGRADOURO")
    @Enumerated(EnumType.STRING)
    private TipoLogradouro tipoLogradouro;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private int numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "MUNICIPIO")
    private String municipio;

    @Column(name = "UF")
    private String estado;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public IntegranteEnderecoEntity(IntegranteEnderecoDto integranteEnderecoDto) {
        if (integranteEnderecoDto.integrante() != null) {
            this.integrante = new IntegranteEntity(integranteEnderecoDto.integrante());
        }
        this.tipo = integranteEnderecoDto.tipo();
        this.inscricaoEstadual = integranteEnderecoDto.inscricaoEstadual();
        this.cep = integranteEnderecoDto.cep();
        this.tipoLogradouro = integranteEnderecoDto.tipoLogradouro();
        this.logradouro = integranteEnderecoDto.logradouro();
        this.numero = integranteEnderecoDto.numero();
        this.complemento = integranteEnderecoDto.complemento();
        this.bairro = integranteEnderecoDto.bairro();
        this.municipio = integranteEnderecoDto.municipio();
        this.estado = integranteEnderecoDto.estado();
        this.versao = LocalDateTime.now();
    }

    public void atualizarIntegranteEndereco(IntegranteEnderecoDto integranteEnderecoDto) {
        if(integranteEnderecoDto.integrante() != null) {
            this.integrante = new IntegranteEntity(integranteEnderecoDto.integrante());
        }
        if(integranteEnderecoDto.tipo() != null) {
            this.tipo = integranteEnderecoDto.tipo();
        }
        if(integranteEnderecoDto.inscricaoEstadual() != null) {
            this.inscricaoEstadual = integranteEnderecoDto.inscricaoEstadual();
        }
        if(integranteEnderecoDto.cep() != null) {
            this.cep = integranteEnderecoDto.cep();
        }
        if(integranteEnderecoDto.tipoLogradouro() != null) {
            this.tipoLogradouro = integranteEnderecoDto.tipoLogradouro();
        }
        if(integranteEnderecoDto.logradouro() != null) {
            this.logradouro = integranteEnderecoDto.logradouro();
        }
        if(integranteEnderecoDto.numero() != 0) {
            this.numero = integranteEnderecoDto.numero();
        }
        if(integranteEnderecoDto.complemento() != null) {
            this.complemento = integranteEnderecoDto.complemento();
        }
        if(integranteEnderecoDto.bairro() != null) {
            this.bairro = integranteEnderecoDto.bairro();
        }
        if(integranteEnderecoDto.municipio() != null) {
            this.municipio = integranteEnderecoDto.municipio();
        }
        if(integranteEnderecoDto.estado() != null) {
            this.estado = integranteEnderecoDto.estado();
        }
        this.versao = LocalDateTime.now();
    }
}
