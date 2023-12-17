package com.learning.api.minisys.entitys.faturamento.pedido;

import com.learning.api.minisys.dtos.faturamento.pedido.NewPedidoDetalheDto;
import com.learning.api.minisys.dtos.faturamento.pedido.PedidoDetalheDto;
import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.entitys.cadastro.item.UnidadeMedidaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido_detalhe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @JoinColumn(name = "PEDIDO")
    @OneToOne
    private PedidoEntity pedido;

    @JoinColumn(name = "ITEM")
    @ManyToOne
    private ItemEntity item;

    @Column(name = "CANCELADO")
    private Boolean cancelado;

    @Column(name = "ORDEM")
    private Long ordem;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "UNIDADE_MEDIDA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeMedida;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "QUANTIDADE_DEVOLVIDA")
    private Double quantidadeDevolvida;

    @Column(name = "QUANTIDADE_FATURADA")
    private Double quantidadeFaturada;

    @Column(name = "QUANTIDADE_ENTREGUE")
    private Double quantidadeEntregue;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;


    public PedidoDetalheEntity(PedidoDetalheDto pedidoDetalheDto) {
        this.pedido = pedidoDetalheDto.pedido() != null ?
                new PedidoEntity(pedidoDetalheDto.pedido()) : null;
        this.item = pedidoDetalheDto.item() != null ?
                new ItemEntity(pedidoDetalheDto.item()) : null;
        this.cancelado = false;
        this.ordem = pedidoDetalheDto.ordem();
        this.descricao = pedidoDetalheDto.descricao();
        this.unidadeMedida = pedidoDetalheDto.unidadeMedida() != null ?
                new UnidadeMedidaEntity(pedidoDetalheDto.unidadeMedida()) : null;
        this.quantidade = pedidoDetalheDto.quantidade();
        this.quantidadeDevolvida = pedidoDetalheDto.quantidadeDevolvida();
        this.quantidadeFaturada = pedidoDetalheDto.quantidadeFaturada();
        this.quantidadeEntregue = pedidoDetalheDto.quantidadeEntregue();
        this.valorUnitario = pedidoDetalheDto.valorUnitario();
        this.valorDesconto = pedidoDetalheDto.valorDesconto();
        this.valorAcrescimo = pedidoDetalheDto.valorAcrescimo();
        this.valorTotal = pedidoDetalheDto.valorTotal();
    }

    public PedidoDetalheEntity(NewPedidoDetalheDto newPedidoDetalheDto) {}

    public void atualizarPedidoDetalhe(PedidoDetalheDto pedidoDetalheDto) {
        if (pedidoDetalheDto.pedido() != null) {
            this.pedido = new PedidoEntity(pedidoDetalheDto.pedido());
        }
        if (pedidoDetalheDto.item() != null) {
            this.item = new ItemEntity(pedidoDetalheDto.item());
        }
        if (pedidoDetalheDto.cancelado() != null) {
            this.cancelado = pedidoDetalheDto.cancelado();
        }
        if (pedidoDetalheDto.ordem() != null) {
            this.ordem = pedidoDetalheDto.ordem();
        }
        if (pedidoDetalheDto.descricao() != null) {
            this.descricao = pedidoDetalheDto.descricao();
        }
        if (pedidoDetalheDto.unidadeMedida() != null) {
            this.unidadeMedida = new UnidadeMedidaEntity(pedidoDetalheDto.unidadeMedida());
        }
        if (pedidoDetalheDto.quantidade() != null) {
            this.quantidade = pedidoDetalheDto.quantidade();
        }
        if (pedidoDetalheDto.quantidadeDevolvida() != null) {
            this.quantidadeDevolvida = pedidoDetalheDto.quantidadeDevolvida();
        }
        if (pedidoDetalheDto.quantidadeFaturada() != null) {
            this.quantidadeFaturada = pedidoDetalheDto.quantidadeFaturada();
        }
        if (pedidoDetalheDto.quantidadeEntregue() != null) {
            this.quantidadeEntregue = pedidoDetalheDto.quantidadeEntregue();
        }
        if (pedidoDetalheDto.valorUnitario() != null) {
            this.valorUnitario = pedidoDetalheDto.valorUnitario();
        }
        if (pedidoDetalheDto.valorDesconto() != null) {
            this.valorDesconto = pedidoDetalheDto.valorDesconto();
        }
        if (pedidoDetalheDto.valorAcrescimo() != null) {
            this.valorAcrescimo = pedidoDetalheDto.valorAcrescimo();
        }
        if (pedidoDetalheDto.valorTotal() != null) {
            this.valorTotal = pedidoDetalheDto.valorTotal();
        }
    }
}
