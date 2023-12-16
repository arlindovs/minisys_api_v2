package com.learning.api.minisys.entitys.faturamento.pedido;

import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.entitys.cadastro.item.UnidadeMedidaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pedido_detalhe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDetalheEntity extends BaseEntity {

    @JoinColumn(name = "PEDIDO")
    @OneToOne
    private PedidoEntity pedido;

    @JoinColumn(name = "ITEM")
    @ManyToOne
    private ItemEntity item;

    @Column(name = "CANCELADO")
    private Boolean cancelado;

    @Column(name = "ORDEM")
    private int ordem;

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
}
