package com.learning.api.minisys.entitys.financeiro.movimentacao;

import com.learning.api.minisys.dtos.financeiro.movimentacao.FormaPagamentoDto;
import com.learning.api.minisys.dtos.financeiro.movimentacao.NewFormaPagamentoDto;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.movimentacao.TipoFormaPagamento;
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

import java.time.LocalDateTime;

@Entity
@Table(name = "forma_pagamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoFormaPagamento tipo;

    @Column(name = "DESCRICAO")
    private String descricao;


    public FormaPagamentoEntity(FormaPagamentoDto formaPagamentoDto) {
        this.descricao = formaPagamentoDto.descricao();
        this.tipo = formaPagamentoDto.tipo();
        this.empresa = formaPagamentoDto.empresa();
        this.status = Status.ATIVO;
        this.versao = LocalDateTime.now();
    }

    public FormaPagamentoEntity(NewFormaPagamentoDto formaPagamentoDto) {}

    public void atualizarFormaPagamento(FormaPagamentoDto formaPagamentoDto) {
        this.descricao = formaPagamentoDto.descricao();
        this.tipo = formaPagamentoDto.tipo();
        this.empresa = formaPagamentoDto.empresa();
        this.versao = LocalDateTime.now();
    }

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
    }
}
