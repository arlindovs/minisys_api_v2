package com.learning.api.minisys.entitys.faturamento.nota_fiscal;

import com.learning.api.minisys.dtos.faturamento.nota_fiscal.NewNotaFiscalDetalheDto;
import com.learning.api.minisys.dtos.faturamento.nota_fiscal.NotaFiscalDetalheDto;
import com.learning.api.minisys.entitys.cadastro.item.ItemEntity;
import com.learning.api.minisys.entitys.cadastro.item.PerfilFiscalEntity;
import com.learning.api.minisys.entitys.cadastro.item.UnidadeMedidaEntity;
import com.learning.api.minisys.enums.item.TipoItem;
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
@Table(name = "nota_fiscal_detalhe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscalDetalheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CODIGO;

    @JoinColumn(name = "NOTA_FISCAL")
    @OneToOne
    private NotaFiscalEntity notaFiscal;

    @JoinColumn(name = "PERFIL_FISCAL")
    @ManyToOne
    private PerfilFiscalEntity perfilFiscal;

    @Column(name = "CANCELADO")
    private Boolean cancelado;

    @Column(name = "ORDEM")
    private Long ordem;

    @Column(name = "TIPO_ITEM")
    @Enumerated(EnumType.STRING)
    private TipoItem tipoItem;

    @JoinColumn(name = "ITEM")
    @ManyToOne
    private ItemEntity item;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JoinColumn(name = "UNIDADE_MEDIDA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeMedida;

    @Column(name = "NCM")
    private String ncm;

    @Column(name = "CEST")
    private String cest;

    @Column(name = "QUANTIDADE")
    private Double quantidade;

    @Column(name = "QUANTIDADE_DEVOLVIDA")
    private Double quantidadeDevolvida;

    @Column(name = "VALOR_UNITARIO")
    private Double valorUnitario;

    @Column(name = "VALOR_DESCONTO")
    private Double valorDesconto;

    @Column(name = "VALOR_ACRESCIMO")
    private Double valorAcrescimo;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;


    public NotaFiscalDetalheEntity(NotaFiscalDetalheDto notaFiscalDetalheDto) {
        this.notaFiscal = notaFiscalDetalheDto.notaFiscal() != null ?
                new NotaFiscalEntity(notaFiscalDetalheDto.notaFiscal()) : null;
        this.perfilFiscal = notaFiscalDetalheDto.perfilFiscal() != null ?
                new PerfilFiscalEntity(notaFiscalDetalheDto.perfilFiscal()) : null;
        this.cancelado = notaFiscalDetalheDto.cancelado();
        this.ordem = notaFiscalDetalheDto.ordem();
        this.tipoItem = notaFiscalDetalheDto.tipoItem();
        this.item = notaFiscalDetalheDto.item() != null ?
                new ItemEntity(notaFiscalDetalheDto.item()) : null;
        this.descricao = notaFiscalDetalheDto.descricao();
        this.unidadeMedida = notaFiscalDetalheDto.unidadeMedida() != null ?
                new UnidadeMedidaEntity(notaFiscalDetalheDto.unidadeMedida()) : null;
        this.ncm = notaFiscalDetalheDto.ncm();
        this.cest = notaFiscalDetalheDto.cest();
        this.quantidade = notaFiscalDetalheDto.quantidade();
        this.quantidadeDevolvida = notaFiscalDetalheDto.quantidadeDevolvida();
        this.valorUnitario = notaFiscalDetalheDto.valorUnitario();
        this.valorDesconto = notaFiscalDetalheDto.valorDesconto();
        this.valorAcrescimo = notaFiscalDetalheDto.valorAcrescimo();
        this.valorTotal = notaFiscalDetalheDto.valorTotal();
    }

    public NotaFiscalDetalheEntity(NewNotaFiscalDetalheDto newNotaFiscalDetalheDto) {}

    public void atualizarNotaFiscalDetalhe(NotaFiscalDetalheDto notaFiscalDetalheDto) {
        if (notaFiscalDetalheDto.notaFiscal() != null) {
            this.notaFiscal = new NotaFiscalEntity(notaFiscalDetalheDto.notaFiscal());
        }
        if (notaFiscalDetalheDto.perfilFiscal() != null) {
            this.perfilFiscal = new PerfilFiscalEntity(notaFiscalDetalheDto.perfilFiscal());
        }
        if (notaFiscalDetalheDto.tipoItem() != null) {
            this.tipoItem = notaFiscalDetalheDto.tipoItem();
        }
        if (notaFiscalDetalheDto.item() != null) {
            this.item = new ItemEntity(notaFiscalDetalheDto.item());
        }
        if (notaFiscalDetalheDto.unidadeMedida() != null) {
            this.unidadeMedida = new UnidadeMedidaEntity(notaFiscalDetalheDto.unidadeMedida());
        }
        if (notaFiscalDetalheDto.ncm() != null) {
            this.ncm = notaFiscalDetalheDto.ncm();
        }
        if (notaFiscalDetalheDto.cest() != null) {
            this.cest = notaFiscalDetalheDto.cest();
        }
        if (notaFiscalDetalheDto.cancelado() != null) {
            this.cancelado = notaFiscalDetalheDto.cancelado();
        }
        if (notaFiscalDetalheDto.ordem() != null) {
            this.ordem = notaFiscalDetalheDto.ordem();
        }
        if (notaFiscalDetalheDto.descricao() != null) {
            this.descricao = notaFiscalDetalheDto.descricao();
        }
        if (notaFiscalDetalheDto.quantidade() != null) {
            this.quantidade = notaFiscalDetalheDto.quantidade();
        }
        if (notaFiscalDetalheDto.quantidadeDevolvida() != null) {
            this.quantidadeDevolvida = notaFiscalDetalheDto.quantidadeDevolvida();
        }
        if (notaFiscalDetalheDto.valorUnitario() != null) {
            this.valorUnitario = notaFiscalDetalheDto.valorUnitario();
        }
        if (notaFiscalDetalheDto.valorDesconto() != null) {
            this.valorDesconto = notaFiscalDetalheDto.valorDesconto();
        }
        if (notaFiscalDetalheDto.valorAcrescimo() != null) {
            this.valorAcrescimo = notaFiscalDetalheDto.valorAcrescimo();
        }
        if (notaFiscalDetalheDto.valorTotal() != null) {
            this.valorTotal = notaFiscalDetalheDto.valorTotal();
        }
    }
}
