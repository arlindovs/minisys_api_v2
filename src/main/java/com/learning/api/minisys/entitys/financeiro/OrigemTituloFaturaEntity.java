package com.learning.api.minisys.entitys.financeiro;

import com.learning.api.minisys.dtos.financeiro.OrigemTituloFaturaDto;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalEntity;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoEntity;
import com.learning.api.minisys.entitys.faturamento.pedido.PedidoEntity;
import com.learning.api.minisys.entitys.financeiro.titulo.TituloEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "origem_titulo_fatura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrigemTituloFaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

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

    public OrigemTituloFaturaEntity(OrigemTituloFaturaDto origemTituloFaturaDto) {
        this.dataCriacao = LocalDateTime.now();
        this.pedido = origemTituloFaturaDto.pedido() != null ?
                new PedidoEntity(origemTituloFaturaDto.pedido()) : null;
        this.ordemServico = origemTituloFaturaDto.ordemServico() != null ?
                new OrdemServicoEntity(origemTituloFaturaDto.ordemServico()) : null;
        this.notaFiscal = origemTituloFaturaDto.notaFiscal() != null ?
                new NotaFiscalEntity(origemTituloFaturaDto.notaFiscal()) : null;
        this.titulo = origemTituloFaturaDto.titulo() != null ?
                new TituloEntity(origemTituloFaturaDto.titulo()) : null;
    }
}
