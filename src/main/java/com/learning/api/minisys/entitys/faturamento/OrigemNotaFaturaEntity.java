package com.learning.api.minisys.entitys.faturamento;

import com.learning.api.minisys.dtos.faturamento.OrigemNotaFaturaDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalDetalheEntity;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoDetalheEntity;
import com.learning.api.minisys.entitys.faturamento.pedido.PedidoDetalheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "origem_nota_fatura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrigemNotaFaturaEntity extends BaseEntity {

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @JoinColumn(name = "PEDIDO_DETALHE")
    @ManyToOne
    private PedidoDetalheEntity pedidoDetalhe;

    @JoinColumn(name = "ORDEM_SERVICO_DETALHE")
    @ManyToOne
    private OrdemServicoDetalheEntity ordemServicoDetalhe;

    @JoinColumn(name = "NOTA_FISCAL_DETALHE")
    @ManyToOne
    private NotaFiscalDetalheEntity notaFiscalDetalhe;


    public OrigemNotaFaturaEntity(OrigemNotaFaturaDto origemNotaFaturaDto) {
        this.dataCriacao = LocalDateTime.now();
        this.pedidoDetalhe = origemNotaFaturaDto.pedidoDetalhe() != null ?
                new PedidoDetalheEntity(origemNotaFaturaDto.pedidoDetalhe()) : null;
        this.ordemServicoDetalhe = origemNotaFaturaDto.ordemServicoDetalhe() != null ?
                new OrdemServicoDetalheEntity(origemNotaFaturaDto.ordemServicoDetalhe()) : null;
        this.notaFiscalDetalhe = origemNotaFaturaDto.notaFiscalDetalhe() != null ?
                new NotaFiscalDetalheEntity(origemNotaFaturaDto.notaFiscalDetalhe()) : null;
    }
}
