package com.learning.api.minisys.entitys.financeiro.movimentacao;

import com.learning.api.minisys.dtos.financeiro.movimentacao.MovimentacaoDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.financeiro.titulo.TituloEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.movimentacao.StatusMovimentacao;
import com.learning.api.minisys.enums.movimentacao.Tipo;
import com.learning.api.minisys.enums.movimentacao.TipoMovimentacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "movimentacao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoEntity extends BaseEntity {

    @Column(name = "STATUS_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private StatusMovimentacao statusMovimentacao;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "TIPO_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @JoinColumn(name = "TITULO")
    @ManyToOne
    private TituloEntity titulo;

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

    @JoinColumn(name = "FORMA_PAGAMENTO")
    @ManyToOne
    private FormaPagamentoEntity formaPagamento;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDateTime dataVencimento;

    @Column(name = "DATA_COMPENSACAO")
    private LocalDateTime dataCompensacao;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "TOTAL")
    private Double total;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public MovimentacaoEntity(MovimentacaoDto movimentacaoDto)
}
