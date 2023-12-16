package com.learning.api.minisys.entitys.faturamento.ordem_servico;

import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.ordem_servico.FinalidadeOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.StatusOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.TipoMovimentacaoOrdem;
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
@Table(name = "ordem_servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoEntity extends BaseEntity {

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
}
