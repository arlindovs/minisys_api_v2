package com.learning.api.minisys.entitys.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.faturamento.ordem_servico.NewOrdemServicoEquipamentoDto;
import com.learning.api.minisys.dtos.faturamento.ordem_servico.OrdemServicoEqipamentoDto;
import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.enums.item.TipoMovimentacaoItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "ordem_servico_equipamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoEquipamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @JoinColumn(name = "ORDEM_SERVICO")
    @OneToOne
    private OrdemServicoEntity ordemServico;

    @Column(name = "TIPO_ITEM")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacaoItem tipoItem;

    @JoinColumn(name = "ITEM")
    @ManyToOne
    private ItemEntity item;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "NUMERO_SERIE")
    private String numeroSerie;

    @Column(name = "QUANTIDADE")
    private Double quantidade;


    public OrdemServicoEquipamentoEntity(OrdemServicoEqipamentoDto ordemServicoEqipamentoDto) {
        this.ordemServico = ordemServicoEqipamentoDto.ordemServico() != null ?
                new OrdemServicoEntity(ordemServicoEqipamentoDto.ordemServico()) : null;
        this.tipoItem = ordemServicoEqipamentoDto.tipoItem();
        this.item = ordemServicoEqipamentoDto.item() != null ?
                new ItemEntity(ordemServicoEqipamentoDto.item()) : null;
        this.descricao = ordemServicoEqipamentoDto.descricao();
        this.observacao = ordemServicoEqipamentoDto.observacao();
        this.numeroSerie = ordemServicoEqipamentoDto.numeroSerie();
        this.quantidade = ordemServicoEqipamentoDto.quantidade();
    }

    public OrdemServicoEquipamentoEntity(NewOrdemServicoEquipamentoDto newOrdemServicoEquipamentoDto) {}

    public void atualizar(OrdemServicoEqipamentoDto ordemServicoEqipamentoDto) {
        if (ordemServicoEqipamentoDto.ordemServico() != null) {
            this.ordemServico = new OrdemServicoEntity(ordemServicoEqipamentoDto.ordemServico());
        }
        if (ordemServicoEqipamentoDto.tipoItem() != null) {
            this.tipoItem = ordemServicoEqipamentoDto.tipoItem();
        }
        if (ordemServicoEqipamentoDto.item() != null) {
            this.item = new ItemEntity(ordemServicoEqipamentoDto.item());
        }
        if (ordemServicoEqipamentoDto.descricao() != null) {
            this.descricao = ordemServicoEqipamentoDto.descricao();
        }
        if (ordemServicoEqipamentoDto.observacao() != null) {
            this.observacao = ordemServicoEqipamentoDto.observacao();
        }
        if (ordemServicoEqipamentoDto.numeroSerie() != null) {
            this.numeroSerie = ordemServicoEqipamentoDto.numeroSerie();
        }
        if (ordemServicoEqipamentoDto.quantidade() != null) {
            this.quantidade = ordemServicoEqipamentoDto.quantidade();
        }
    }
}
