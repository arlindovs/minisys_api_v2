package com.learning.api.minisys.entitys.financeiro;

import com.learning.api.minisys.dtos.financeiro.OrigemTituloFaturaDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalEntity;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoEntity;
import com.learning.api.minisys.entitys.faturamento.pedido.PedidoEntity;
import com.learning.api.minisys.entitys.financeiro.titulo.TituloEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "origem_titulo_fatura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrigemTituloFaturaEntity extends BaseEntity {

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @JoinColumn(name = "PEDIDO")
    @ManyToOne
    private PedidoEntity pedido;

    @JoinColumn(name = "ORDEM_SERVICO")
    @ManyToOne
    private OrdemServicoEntity ordemServico;

    @JoinColumn(name = "NOTA_FISCAL")
    @ManyToOne
    private NotaFiscalEntity notaFiscal;

    @JoinColumn(name = "TITULO")
    @ManyToOne
    private TituloEntity titulo;

    public OrigemTituloFaturaEntity(OrigemTituloFaturaDto origemTituloFaturaDto)
}
