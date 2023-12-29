package com.learning.api.minisys.entitys.faturamento.pedido;

import com.learning.api.minisys.dtos.faturamento.pedido.NewPedidoDto;
import com.learning.api.minisys.dtos.faturamento.pedido.PedidoDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.pedido.FinalidadePedido;
import com.learning.api.minisys.enums.pedido.StatusPedido;
import com.learning.api.minisys.enums.pedido.TipoMovimentacaoPedido;
import com.learning.api.minisys.enums.pedido.TipoPedido;
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
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoPedido tipo;

    @Column(name = "TIPO_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacaoPedido tipoMovimentacao;

    @Column(name = "FINALIDADE")
    @Enumerated(EnumType.STRING)
    private FinalidadePedido finalidade;

    @Column(name = "STATUS_PEDIDO")
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

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

    @JoinColumn(name = "INTEGRANTE")
    @ManyToOne
    private IntegranteEntity integrante;

    @Column(name = "TOTAL_PRODUTO")
    private Double totalProduto;

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

    public PedidoEntity(PedidoDto pedidoDto) {
        this.tipo = pedidoDto.tipo();
        this.tipoMovimentacao = pedidoDto.tipoMovimentacao();
        this.finalidade = FinalidadePedido.NORMAL;
        this.statusPedido = pedidoDto.statusPedido();
        this.numero = pedidoDto.numero();
        this.controle = pedidoDto.controle();
        this.dataEmissao = pedidoDto.dataEmissao();
        this.dataEntrega = pedidoDto.dataEntrega();
        this.dataFatura = pedidoDto.dataFatura();
        this.dataValidade = pedidoDto.dataValidade();
        this.dataPrevisao = pedidoDto.dataPrevisao();
        this.integrante = pedidoDto.integrante() != null ?
                new IntegranteEntity(pedidoDto.integrante()) : null;
        this.totalProduto = pedidoDto.totalProduto();
        this.totalDesconto = pedidoDto.totalDesconto();
        this.totalAcrescimo = pedidoDto.totalAcrescimo();
        this.total = pedidoDto.total();
        this.empresa = pedidoDto.empresa();
        this.status = Status.NORMAL;
        this.versao = LocalDateTime.now();
    }

    public PedidoEntity(NewPedidoDto pedido) {}

    public void atualizarPedido(PedidoDto pedidoDto) {
        if (pedidoDto.tipo() != null) {
            this.tipo = pedidoDto.tipo();
        }
        if (pedidoDto.tipoMovimentacao() != null) {
            this.tipoMovimentacao = pedidoDto.tipoMovimentacao();
        }
        if (pedidoDto.finalidade() != null) {
            this.finalidade = pedidoDto.finalidade();
        }
        if (pedidoDto.statusPedido() != null) {
            this.statusPedido = pedidoDto.statusPedido();
        }
        if (pedidoDto.numero() != null) {
            this.numero = pedidoDto.numero();
        }
        if (pedidoDto.controle() != null) {
            this.controle = pedidoDto.controle();
        }
        if (pedidoDto.dataEmissao() != null) {
            this.dataEmissao = pedidoDto.dataEmissao();
        }
        if (pedidoDto.dataEntrega() != null) {
            this.dataEntrega = pedidoDto.dataEntrega();
        }
        if (pedidoDto.dataFatura() != null) {
            this.dataFatura = pedidoDto.dataFatura();
        }
        if (pedidoDto.dataValidade() != null) {
            this.dataValidade = pedidoDto.dataValidade();
        }
        if (pedidoDto.dataPrevisao() != null) {
            this.dataPrevisao = pedidoDto.dataPrevisao();
        }
        if (pedidoDto.integrante() != null) {
            this.integrante = new IntegranteEntity(pedidoDto.integrante());
        }
        if (pedidoDto.totalProduto() != null) {
            this.totalProduto = pedidoDto.totalProduto();
        }
        if (pedidoDto.totalDesconto() != null) {
            this.totalDesconto = pedidoDto.totalDesconto();
        }
        if (pedidoDto.totalAcrescimo() != null) {
            this.totalAcrescimo = pedidoDto.totalAcrescimo();
        }
        if (pedidoDto.total() != null) {
            this.total = pedidoDto.total();
        }
        if (pedidoDto.empresa() != null) {
            this.empresa = pedidoDto.empresa();
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
