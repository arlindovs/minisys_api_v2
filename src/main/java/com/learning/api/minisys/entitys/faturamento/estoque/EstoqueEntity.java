package com.learning.api.minisys.entitys.faturamento.estoque;

import com.learning.api.minisys.dtos.faturamento.estoque.EstoqueDto;
import com.learning.api.minisys.dtos.faturamento.estoque.NewEstoqueDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalDetalheEntity;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoDetalheEntity;
import com.learning.api.minisys.entitys.faturamento.pedido.PedidoDetalheEntity;
import com.learning.api.minisys.enums.estoque.TipoEstoque;
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
@Table(name = "estoque")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoEstoque tipo;

    @Column(name = "DATA_OPERACAO")
    private LocalDateTime dataOperacao;

    @Column(name = "RESERVADO")
    private Boolean reservado;

    @JoinColumn(name = "ITEM")
    @ManyToOne
    private ItemEntity item;

    @JoinColumn(name = "UNDIADE_MEDIDA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeMedida;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "LOTE")
    private String lote;

    @Column(name = "NUMERO_SERIE")
    private String numeroSerie;

    @Column(name = "DATA_VALIDADE")
    private LocalDateTime dataValidade;

    @Column(name = "DATA_FABRICACAO")
    private LocalDateTime dataFabricacao;

    @JoinColumn(name = "FUNCIONARIO")
    @ManyToOne
    private IntegranteEntity funcionario;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "MOTIVO_ACERTO")
    private String motivoAcerto;

    @JoinColumn(name = "PEDIDO_DETALHE")
    @ManyToOne
    private PedidoDetalheEntity pedidoDetalhe;

    @JoinColumn(name = "ORDEM_SERVICO_DETALHE")
    @ManyToOne
    private OrdemServicoDetalheEntity ordemServicoDetalhe;

    @JoinColumn(name = "NOTA_FISCAL_DETALHE")
    @ManyToOne
    private NotaFiscalDetalheEntity notaFiscalDetalhe;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public EstoqueEntity(EstoqueDto estoqueDto) {
        this.tipo = estoqueDto.tipo();
        this.dataOperacao = estoqueDto.dataOperacao();
        this.reservado = estoqueDto.reservado();
        this.item = estoqueDto.item() != null ?
                new ItemEntity(estoqueDto.item()) : null;
        this.unidadeMedida = estoqueDto.unidadeMedida() != null ?
                new UnidadeMedidaEntity(estoqueDto.unidadeMedida()) : null;
        this.quantidade = estoqueDto.quantidade();
        this.valorUnitario = estoqueDto.valorUnitario();
        this.valorTotal = estoqueDto.valorTotal();
        this.lote = estoqueDto.lote();
        this.numeroSerie = estoqueDto.numeroSerie();
        this.dataValidade = estoqueDto.dataValidade();
        this.dataFabricacao = estoqueDto.dataFabricacao();
        this.funcionario = estoqueDto.funcionario() != null ?
                new IntegranteEntity(estoqueDto.funcionario()) : null;
        this.observacao = estoqueDto.observacao();
        this.motivoAcerto = estoqueDto.motivoAcerto();
        this.pedidoDetalhe = estoqueDto.pedidoDetalhe() != null ?
                new PedidoDetalheEntity(estoqueDto.pedidoDetalhe()) : null;
        this.ordemServicoDetalhe = estoqueDto.ordemServicoDetalhe() != null ?
                new OrdemServicoDetalheEntity(estoqueDto.ordemServicoDetalhe()) : null;
        this.notaFiscalDetalhe = estoqueDto.notaFiscalDetalhe() != null ?
                new NotaFiscalDetalheEntity(estoqueDto.notaFiscalDetalhe()) : null;
        this.empresa = estoqueDto.empresa();
        this.versao = LocalDateTime.now();
    }

    public EstoqueEntity(NewEstoqueDto newEstoqueDto) {}

    public void atualizarEstoque(EstoqueDto estoqueDto) {
        if (estoqueDto.tipo() != null) {
            this.tipo = estoqueDto.tipo();
        }
        if (estoqueDto.dataOperacao() != null) {
            this.dataOperacao = estoqueDto.dataOperacao();
        }
        if (estoqueDto.reservado() != null) {
            this.reservado = estoqueDto.reservado();
        }
        if (estoqueDto.item() != null) {
            this.item = new ItemEntity(estoqueDto.item());
        }
        if (estoqueDto.unidadeMedida() != null) {
            this.unidadeMedida = new UnidadeMedidaEntity(estoqueDto.unidadeMedida());
        }
        if (estoqueDto.quantidade() != null) {
            this.quantidade = estoqueDto.quantidade();
        }
        if (estoqueDto.valorUnitario() != null) {
            this.valorUnitario = estoqueDto.valorUnitario();
        }
        if (estoqueDto.valorTotal() != null) {
            this.valorTotal = estoqueDto.valorTotal();
        }
        if (estoqueDto.lote() != null) {
            this.lote = estoqueDto.lote();
        }
        if (estoqueDto.numeroSerie() != null) {
            this.numeroSerie = estoqueDto.numeroSerie();
        }
        if (estoqueDto.dataValidade() != null) {
            this.dataValidade = estoqueDto.dataValidade();
        }
        if (estoqueDto.dataFabricacao() != null) {
            this.dataFabricacao = estoqueDto.dataFabricacao();
        }
        if (estoqueDto.funcionario() != null) {
            this.funcionario = new IntegranteEntity(estoqueDto.funcionario());
        }
        if (estoqueDto.observacao() != null) {
            this.observacao = estoqueDto.observacao();
        }
        if (estoqueDto.motivoAcerto() != null) {
            this.motivoAcerto = estoqueDto.motivoAcerto();
        }
        if (estoqueDto.pedidoDetalhe() != null) {
            this.pedidoDetalhe = new PedidoDetalheEntity(estoqueDto.pedidoDetalhe());
        }
        if (estoqueDto.ordemServicoDetalhe() != null) {
            this.ordemServicoDetalhe = new OrdemServicoDetalheEntity(estoqueDto.ordemServicoDetalhe());
        }
        if (estoqueDto.notaFiscalDetalhe() != null) {
            this.notaFiscalDetalhe = new NotaFiscalDetalheEntity(estoqueDto.notaFiscalDetalhe());
        }
        if (estoqueDto.empresa() != null) {
            this.empresa = estoqueDto.empresa();
        }
        this.versao = LocalDateTime.now();
    }
}
