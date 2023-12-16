package com.learning.api.minisys.entitys.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.faturamento.ordem_servico.OrdemServicoDetalheDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.minisys.enums.item.TipoItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "ordem_servico_detalhe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoDetalheEntity extends BaseEntity {

    @JoinColumn(name = "ORDEM_SERVICO")
    @OneToOne
    private OrdemServicoEntity ordemServico;

    @Column(name = "TIPO_ITEM")
    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;

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

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;


    public OrdemServicoDetalheEntity(OrdemServicoDetalheDto ordemServicoDetalheDto) {
        this.ordemServico = ordemServicoDetalheDto.ordemServico() != null ?
                new OrdemServicoEntity(ordemServicoDetalheDto.ordemServico()) : null;
        this.tipoItem = ordemServicoDetalheDto.tipoItem();
        this.item = ordemServicoDetalheDto.item() != null ?
                new ItemEntity(ordemServicoDetalheDto.item()) : null;
        this.cancelado = ordemServicoDetalheDto.cancelado();
        this.ordem = ordemServicoDetalheDto.ordem();
        this.descricao = ordemServicoDetalheDto.descricao();
        this.unidadeMedida = ordemServicoDetalheDto.unidadeMedida() != null ?
                new UnidadeMedidaEntity(ordemServicoDetalheDto.unidadeMedida()) : null;
        this.quantidade = ordemServicoDetalheDto.quantidade();
        this.quantidadeDevolvida = ordemServicoDetalheDto.quantidadeDevolvida();
        this.quantidadeFaturada = ordemServicoDetalheDto.quantidadeFaturada();
        this.valorUnitario = ordemServicoDetalheDto.valorUnitario();
        this.valorDesconto = ordemServicoDetalheDto.valorDesconto();
        this.valorAcrescimo = ordemServicoDetalheDto.valorAcrescimo();
        this.valorTotal = ordemServicoDetalheDto.valorTotal();
    }

    public OrdemServicoDetalheEntity(NewOrdemServicoDetalheDto newOrdemServicoDetalheDto)
}
