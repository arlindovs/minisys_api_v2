package com.learning.api.minisys.entitys.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.faturamento.ordem_servico.NewOrdemServicoDto;
import com.learning.api.minisys.dtos.faturamento.ordem_servico.OrdemServicoDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.ordem_servico.FinalidadeOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.StatusOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.TipoMovimentacaoOrdem;
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

import java.time.LocalDateTime;

@Entity
@Table(name = "ordem_servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacaoOrdem tipoMovimentacao;

    @Column(name = "FINALIDADE")
    @Enumerated(EnumType.STRING)
    private FinalidadeOrdemServico finalidade;

    @Column(name = "STATUS_ORDEM")
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico statusOrdem;

    @Column(name = "NUMERO")
    private Long numero;

    @Column(name = "CONTROLE")
    private String controle;

    @Column(name = "DATA_EMISSAO")
    private LocalDateTime dataEmissao;

    @Column(name = "DATA_ENTREGA")
    private LocalDateTime dataEntrega;

    @Column(name = "DATA_FATURA")
    private LocalDateTime dataFatura;

    @Column(name = "DATA_VALIDADE")
    private LocalDateTime dataValidade;

    @Column(name = "DATA_PREVISAO")
    private LocalDateTime dataPrevisao;

    @Column(name = "DATA_SERVICO_INICIO")
    private LocalDateTime dataServicoInicio;

    @Column(name = "DATA_SERVICO_FIM")
    private LocalDateTime dataServicoFim;

    @JoinColumn(name = "INTEGRANTE")
    @ManyToOne
    private IntegranteEntity integrante;

    @Column(name = "TOTAL_PRODUTO")
    private Double totalProduto;

    @Column(name = "TOTAL_SERVICO")
    private Double totalServico;

    @Column(name = "TOTAL_DESCONTO")
    private Double totalDesconto;

    @Column(name = "TOTAL_ACRESCIMO")
    private Double totalAcrescimo;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public OrdemServicoEntity(OrdemServicoDto ordemServicoDto) {
        this.tipoMovimentacao = ordemServicoDto.tipoMovimentacao();
        this.finalidade = ordemServicoDto.finalidade();
        this.statusOrdem = ordemServicoDto.statusOrdem();
        this.numero = ordemServicoDto.numero();
        this.controle = ordemServicoDto.controle();
        this.dataEmissao = ordemServicoDto.dataEmissao();
        this.dataEntrega = ordemServicoDto.dataEntrega();
        this.dataFatura = ordemServicoDto.dataFatura();
        this.dataValidade = ordemServicoDto.dataValidade();
        this.dataPrevisao = ordemServicoDto.dataPrevisao();
        this.dataServicoInicio = ordemServicoDto.dataServicoInicio();
        this.dataServicoFim = ordemServicoDto.dataServicoFim();
        this.integrante = ordemServicoDto.integrante() != null ?
                new IntegranteEntity(ordemServicoDto.integrante()) : null;
        this.totalProduto = ordemServicoDto.totalProduto();
        this.totalServico = ordemServicoDto.totalServico();
        this.totalDesconto = ordemServicoDto.totalDesconto();
        this.totalAcrescimo = ordemServicoDto.totalAcrescimo();
        this.total = ordemServicoDto.total();
        this.empresa = ordemServicoDto.empresa();
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public OrdemServicoEntity(NewOrdemServicoDto ordemServico) {}

    public void atualizarOrdemServico(OrdemServicoDto ordemServicoDto) {
        if (ordemServicoDto.tipoMovimentacao() != null) {
            this.tipoMovimentacao = ordemServicoDto.tipoMovimentacao();
        }
        if (ordemServicoDto.finalidade() != null) {
            this.finalidade = ordemServicoDto.finalidade();
        }
        if (ordemServicoDto.statusOrdem() != null) {
            this.statusOrdem = ordemServicoDto.statusOrdem();
        }
        if (ordemServicoDto.numero() != null) {
            this.numero = ordemServicoDto.numero();
        }
        if (ordemServicoDto.controle() != null) {
            this.controle = ordemServicoDto.controle();
        }
        if (ordemServicoDto.dataEmissao() != null) {
            this.dataEmissao = ordemServicoDto.dataEmissao();
        }
        if (ordemServicoDto.dataEntrega() != null) {
            this.dataEntrega = ordemServicoDto.dataEntrega();
        }
        if (ordemServicoDto.dataFatura() != null) {
            this.dataFatura = ordemServicoDto.dataFatura();
        }
        if (ordemServicoDto.dataValidade() != null) {
            this.dataValidade = ordemServicoDto.dataValidade();
        }
        if (ordemServicoDto.dataPrevisao() != null) {
            this.dataPrevisao = ordemServicoDto.dataPrevisao();
        }
        if (ordemServicoDto.dataServicoInicio() != null) {
            this.dataServicoInicio = ordemServicoDto.dataServicoInicio();
        }
        if (ordemServicoDto.dataServicoFim() != null) {
            this.dataServicoFim = ordemServicoDto.dataServicoFim();
        }
        if (ordemServicoDto.integrante() != null) {
            this.integrante = new IntegranteEntity(ordemServicoDto.integrante());
        }
        if (ordemServicoDto.totalProduto() != null) {
            this.totalProduto = ordemServicoDto.totalProduto();
        }
        if (ordemServicoDto.totalServico() != null) {
            this.totalServico = ordemServicoDto.totalServico();
        }
        if (ordemServicoDto.totalDesconto() != null) {
            this.totalDesconto = ordemServicoDto.totalDesconto();
        }
        if (ordemServicoDto.totalAcrescimo() != null) {
            this.totalAcrescimo = ordemServicoDto.totalAcrescimo();
        }
        if (ordemServicoDto.total() != null) {
            this.total = ordemServicoDto.total();
        }
        if (ordemServicoDto.empresa() != null) {
            this.empresa = ordemServicoDto.empresa();
        }
        this.versao = LocalDateTime.now();
    }


    public void setStatusNormal() {
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public void setStatusCancelado() {
        this.status = Status.CANCELADO;
        this.versao = LocalDateTime.now();
    }
}
