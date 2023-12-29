package com.learning.api.minisys.entitys.financeiro.titulo;

import com.learning.api.minisys.dtos.financeiro.titulo.NewTituloDto;
import com.learning.api.minisys.dtos.financeiro.titulo.TituloDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.titulo.StatusTitulo;
import com.learning.api.minisys.enums.titulo.TipoTitulo;
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
@Table(name = "titulo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TituloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "STATUS_TITULO")
    @Enumerated(EnumType.STRING)
    private StatusTitulo statusTitulo;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoTitulo tipo;

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

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDateTime dataVencimento;

    @Column(name = "DATA_ULTIMO_PAGAMENTO")
    private LocalDateTime dataUltimoPagamento;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "VALOR_JUROS")
    private Double valorJuros;

    @Column(name = "VALOR_MULTA")
    private Double valorMulta;

    @Column(name = "VALOR_PAGO")
    private Double valorPago;

    @Column(name = "VALOR_EM_ABERTO")
    private Double valorEmAberto;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public TituloEntity(TituloDto tituloDto) {
        this.statusTitulo = tituloDto.statusTitulo();
        this.tipo = tituloDto.tipo();
        this.descricao = tituloDto.descricao();
        this.observacao = tituloDto.observacao();
        this.integrante = tituloDto.integrante() != null ?
                new IntegranteEntity(tituloDto.integrante()) : null;
        this.funcionario = tituloDto.funcionario() != null ?
                new IntegranteEntity(tituloDto.funcionario()) : null;
        this.dataLancamento = tituloDto.dataLancamento();
        this.dataVencimento = tituloDto.dataVencimento();
        this.dataUltimoPagamento = tituloDto.dataUltimoPagamento();
        this.valor = tituloDto.valor();
        this.valorDesconto = tituloDto.valorDesconto();
        this.valorAcrescimo = tituloDto.valorAcrescimo();
        this.valorJuros = tituloDto.valorJuros();
        this.valorMulta = tituloDto.valorMulta();
        this.valorPago = tituloDto.valorPago();
        this.valorEmAberto = tituloDto.valorEmAberto();
        this.total = tituloDto.total();
        this.empresa = tituloDto.empresa();
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public TituloEntity(NewTituloDto newTituloDto) {}

    public void atualizarTitulo(TituloDto tituloDto) {
        if (tituloDto.statusTitulo() != null) {
            this.statusTitulo = tituloDto.statusTitulo();
        }
        if (tituloDto.tipo() != null) {
            this.tipo = tituloDto.tipo();
        }
        if (tituloDto.descricao() != null) {
            this.descricao = tituloDto.descricao();
        }
        if (tituloDto.observacao() != null) {
            this.observacao = tituloDto.observacao();
        }
        if (tituloDto.integrante() != null) {
            this.integrante = new IntegranteEntity(tituloDto.integrante());
        }
        if (tituloDto.funcionario() != null) {
            this.funcionario = new IntegranteEntity(tituloDto.funcionario());
        }
        if (tituloDto.dataLancamento() != null) {
            this.dataLancamento = tituloDto.dataLancamento();
        }
        if (tituloDto.dataVencimento() != null) {
            this.dataVencimento = tituloDto.dataVencimento();
        }
        if (tituloDto.dataUltimoPagamento() != null) {
            this.dataUltimoPagamento = tituloDto.dataUltimoPagamento();
        }
        if (tituloDto.valor() != null) {
            this.valor = tituloDto.valor();
        }
        if (tituloDto.valorDesconto() != null) {
            this.valorDesconto = tituloDto.valorDesconto();
        }
        if (tituloDto.valorAcrescimo() != null) {
            this.valorAcrescimo = tituloDto.valorAcrescimo();
        }
        if (tituloDto.valorJuros() != null) {
            this.valorJuros = tituloDto.valorJuros();
        }
        if (tituloDto.valorMulta() != null) {
            this.valorMulta = tituloDto.valorMulta();
        }
        if (tituloDto.valorPago() != null) {
            this.valorPago = tituloDto.valorPago();
        }
        if (tituloDto.valorEmAberto() != null) {
            this.valorEmAberto = tituloDto.valorEmAberto();
        }
        if (tituloDto.total() != null) {
            this.total = tituloDto.total();
        }
        if (tituloDto.empresa() != null) {
            this.empresa = tituloDto.empresa();
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
