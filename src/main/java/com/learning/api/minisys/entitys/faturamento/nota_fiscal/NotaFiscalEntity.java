package com.learning.api.minisys.entitys.faturamento.nota_fiscal;

import com.learning.api.minisys.dtos.faturamento.nota_fiscal.NewNotaFiscalDto;
import com.learning.api.minisys.dtos.faturamento.nota_fiscal.NotaFiscalDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.nota_fiscal.FinalidadeNotaFiscal;
import com.learning.api.minisys.enums.nota_fiscal.TipoNotaFiscal;
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

import java.sql.Blob;
import java.time.LocalDateTime;

@Entity
@Table(name = "nota_fiscal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoNotaFiscal tipo;

    @Column(name = "FINALIDADE")
    @Enumerated(EnumType.STRING)
    private FinalidadeNotaFiscal finalidade;

    @Column(name = "NUMERO")
    private Long numero;

    @Column(name = "RDS")
    private Long rds;

    @Column(name = "CHAVE_ACESSO")
    private String chaveAcesso;

    @Column(name = "DATA_EMISSAO")
    private LocalDateTime dataEmissao;

    @Column(name = "DATA_ENTRADA_SAIDA")
    private LocalDateTime dataEntradaSaida;

    @Column(name = "DATA_FATURA")
    private LocalDateTime dataFatura;

    @Column(name = "DATA_REFERENCIA_FISCAL")
    private LocalDateTime dataReferenciaFiscal;

    @Column(name = "DATA_ENVIO")
    private LocalDateTime dataEnvio;

    @Column(name = "DATA_CONFIRMACAO")
    private LocalDateTime dataConfirmacao;

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

    @Column(name = "XML")
    private Blob xml;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;

    public NotaFiscalEntity(NotaFiscalDto notaFiscalDto) {
        this.tipo = notaFiscalDto.tipo();
        this.finalidade = notaFiscalDto.finalidade();
        this.numero = notaFiscalDto.numero();
        this.rds = notaFiscalDto.rds();
        this.chaveAcesso = notaFiscalDto.chaveAcesso();
        this.dataEmissao = notaFiscalDto.dataEmissao();
        this.dataEntradaSaida = notaFiscalDto.dataEntradaSaida();
        this.dataFatura = notaFiscalDto.dataFatura();
        this.dataReferenciaFiscal = notaFiscalDto.dataReferenciaFiscal();
        this.dataEnvio = notaFiscalDto.dataEnvio();
        this.dataConfirmacao = notaFiscalDto.dataConfirmacao();
        this.integrante = notaFiscalDto.integrante() != null ?
                new IntegranteEntity(notaFiscalDto.integrante()) : null;
        this.totalProduto = notaFiscalDto.totalProduto();
        this.totalServico = notaFiscalDto.totalServico();
        this.totalDesconto = notaFiscalDto.totalDesconto();
        this.totalAcrescimo = notaFiscalDto.totalAcrescimo();
        this.total = notaFiscalDto.total();
        this.xml = notaFiscalDto.xml();
        this.empresa = notaFiscalDto.empresa();
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public NotaFiscalEntity(NewNotaFiscalDto newNotaFiscalDto) {}

    public void atualizarNotaFiscal(NotaFiscalDto notaFiscalDto) {
        if (notaFiscalDto.tipo() != null) {
            this.tipo = notaFiscalDto.tipo();
        }
        if (notaFiscalDto.finalidade() != null) {
            this.finalidade = notaFiscalDto.finalidade();
        }
        if (notaFiscalDto.numero() != null) {
            this.numero = notaFiscalDto.numero();
        }
        if (notaFiscalDto.rds() != null) {
            this.rds = notaFiscalDto.rds();
        }
        if (notaFiscalDto.chaveAcesso() != null) {
            this.chaveAcesso = notaFiscalDto.chaveAcesso();
        }
        if (notaFiscalDto.dataEmissao() != null) {
            this.dataEmissao = notaFiscalDto.dataEmissao();
        }
        if (notaFiscalDto.dataEntradaSaida() != null) {
            this.dataEntradaSaida = notaFiscalDto.dataEntradaSaida();
        }
        if (notaFiscalDto.dataFatura() != null) {
            this.dataFatura = notaFiscalDto.dataFatura();
        }
        if (notaFiscalDto.dataReferenciaFiscal() != null) {
            this.dataReferenciaFiscal = notaFiscalDto.dataReferenciaFiscal();
        }
        if (notaFiscalDto.dataEnvio() != null) {
            this.dataEnvio = notaFiscalDto.dataEnvio();
        }
        if (notaFiscalDto.dataConfirmacao() != null) {
            this.dataConfirmacao = notaFiscalDto.dataConfirmacao();
        }
        if (notaFiscalDto.integrante() != null) {
            this.integrante = new IntegranteEntity(notaFiscalDto.integrante());
        }
        if (notaFiscalDto.totalProduto() != null) {
            this.totalProduto = notaFiscalDto.totalProduto();
        }
        if (notaFiscalDto.totalServico() != null) {
            this.totalServico = notaFiscalDto.totalServico();
        }
        if (notaFiscalDto.totalDesconto() != null) {
            this.totalDesconto = notaFiscalDto.totalDesconto();
        }
        if (notaFiscalDto.totalAcrescimo() != null) {
            this.totalAcrescimo = notaFiscalDto.totalAcrescimo();
        }
        if (notaFiscalDto.total() != null) {
            this.total = notaFiscalDto.total();
        }
        if (notaFiscalDto.empresa() != null) {
            this.empresa = notaFiscalDto.empresa();
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
