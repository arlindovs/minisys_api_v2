package com.learning.api.minisys.entitys.financeiro.movimentacao;

import com.learning.api.minisys.dtos.financeiro.movimentacao.MovimentacaoDto;
import com.learning.api.minisys.dtos.financeiro.movimentacao.NewMovimentacaoDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.financeiro.titulo.TituloEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.movimentacao.StatusMovimentacao;
import com.learning.api.minisys.enums.movimentacao.Tipo;
import com.learning.api.minisys.enums.movimentacao.TipoMovimentacao;
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
@Table(name = "movimentacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "STATUS_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private StatusMovimentacao statusMovimentacao;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "TIPO_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @JoinColumn(name = "TITULO")
    @ManyToOne
    private TituloEntity titulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @JoinColumn(name = "INTEGRANTE")
    @ManyToOne
    private IntegranteEntity integrante;

    @JoinColumn(name = "FUNCIONARIO")
    @ManyToOne
    private IntegranteEntity funcionario;

    @JoinColumn(name = "FORMA_PAGAMENTO")
    @ManyToOne
    private FormaPagamentoEntity formaPagamento;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDateTime dataVencimento;

    @Column(name = "DATA_COMPENSACAO")
    private LocalDateTime dataCompensacao;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public MovimentacaoEntity(MovimentacaoDto movimentacaoDto) {
        this.statusMovimentacao = movimentacaoDto.statusMovimentacao();
        this.tipo = movimentacaoDto.tipo();
        this.tipoMovimentacao = movimentacaoDto.tipoMovimentacao();
        this.titulo = movimentacaoDto.titulo() != null ?
                new TituloEntity(movimentacaoDto.titulo()) : null;
        this.descricao = movimentacaoDto.descricao();
        this.observacao = movimentacaoDto.observacao();
        this.integrante = movimentacaoDto.integrante() != null ?
                new IntegranteEntity(movimentacaoDto.integrante()) : null;
        this.funcionario = movimentacaoDto.funcionario() != null ?
                new IntegranteEntity(movimentacaoDto.funcionario()) : null;
        this.formaPagamento = movimentacaoDto.formaPagamento() != null ?
                new FormaPagamentoEntity(movimentacaoDto.formaPagamento()) : null;
        this.dataLancamento = movimentacaoDto.dataLancamento();
        this.dataVencimento = movimentacaoDto.dataVencimento();
        this.dataCompensacao = movimentacaoDto.dataCompensacao();
        this.valor = movimentacaoDto.valor();
        this.valorDesconto = movimentacaoDto.valorDesconto();
        this.valorAcrescimo = movimentacaoDto.valorAcrescimo();
        this.total = movimentacaoDto.total();
        this.empresa = movimentacaoDto.empresa();
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public MovimentacaoEntity(NewMovimentacaoDto newMovimentacaoDto) {}

    public void atualizarMovimentacao(MovimentacaoDto movimentacaoDto) {
        if (movimentacaoDto.statusMovimentacao() != null) {
            this.statusMovimentacao = movimentacaoDto.statusMovimentacao();
        }
        if (movimentacaoDto.tipo() != null) {
            this.tipo = movimentacaoDto.tipo();
        }
        if (movimentacaoDto.tipoMovimentacao() != null) {
            this.tipoMovimentacao = movimentacaoDto.tipoMovimentacao();
        }
        if (movimentacaoDto.titulo() != null) {
            this.titulo = new TituloEntity(movimentacaoDto.titulo());
        }
        if (movimentacaoDto.descricao() != null) {
            this.descricao = movimentacaoDto.descricao();
        }
        if (movimentacaoDto.observacao() != null) {
            this.observacao = movimentacaoDto.observacao();
        }
        if (movimentacaoDto.integrante() != null) {
            this.integrante = new IntegranteEntity(movimentacaoDto.integrante());
        }
        if (movimentacaoDto.funcionario() != null) {
            this.funcionario = new IntegranteEntity(movimentacaoDto.funcionario());
        }
        if (movimentacaoDto.formaPagamento() != null) {
            this.formaPagamento = new FormaPagamentoEntity(movimentacaoDto.formaPagamento());
        }
        if (movimentacaoDto.dataLancamento() != null) {
            this.dataLancamento = movimentacaoDto.dataLancamento();
        }
        if (movimentacaoDto.dataVencimento() != null) {
            this.dataVencimento = movimentacaoDto.dataVencimento();
        }
        if (movimentacaoDto.dataCompensacao() != null) {
            this.dataCompensacao = movimentacaoDto.dataCompensacao();
        }
        if (movimentacaoDto.valor() != null) {
            this.valor = movimentacaoDto.valor();
        }
        if (movimentacaoDto.valorDesconto() != null) {
            this.valorDesconto = movimentacaoDto.valorDesconto();
        }
        if (movimentacaoDto.valorAcrescimo() != null) {
            this.valorAcrescimo = movimentacaoDto.valorAcrescimo();
        }
        if (movimentacaoDto.total() != null) {
            this.total = movimentacaoDto.total();
        }
        if (movimentacaoDto.empresa() != null) {
            this.empresa = movimentacaoDto.empresa();
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
