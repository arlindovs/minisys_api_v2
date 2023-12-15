package com.learning.api.minisys.entitys.cadastro.item;

import com.learning.api.minisys.dtos.cadastro.item.ItemDto;
import com.learning.api.minisys.dtos.cadastro.item.NewItemDto;
import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.enums.item.OrigemItem;
import com.learning.api.minisys.enums.item.TipoItem;
import com.learning.api.minisys.enums.item.TipoMovimentacaoItem;
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
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity extends BaseEntity {

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoItem tipo;

    @JoinColumn(name = "PERFIL_FISCAL")
    @ManyToOne
    private PerfilFiscalEntity perfilFiscal;

    @JoinColumn(name = "GRUPO_ITEM")
    @ManyToOne
    private ItemGrupoEntity grupoItem;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @JoinColumn(name = "UNIDADE_VENDA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeVenda;

    @JoinColumn(name = "UNIDADE_COMPRA")
    @ManyToOne
    private UnidadeMedidaEntity unidadeCompra;

    @Column(name = "UNIDADE_COMPRA_FATOR")
    private Double unidadeCompraFator;

    @JoinColumn(name = "FABRICANTE")
    @ManyToOne
    private FabricanteEntity fabricante;

    @Column(name = "ORIGEM")
    @Enumerated(EnumType.STRING)
    private OrigemItem origem;

    @Column(name = "NCM")
    private String ncm;

    @Column(name = "CEST")
    private String cest;

    @Column(name = "CODIGO_BARRAS", unique = true)
    private String codigoBarras;

    @Column(name = "CODIGO_ORIGINAL", unique = true)
    private String codigoOriginal;

    @Column(name = "TIPO_MOVIMENTACAO")
    private TipoMovimentacaoItem tipoMovimentacao;

    @Column(name = "PRECO_CUSTO")
    private Double precoCusto;

    @Column(name = "PRECO_VENDA")
    private Double precoVenda;

    @Column(name = "MARGEM_LUCRO")
    private Double margemLucro;

    @Column(name = "PRECO_MINIMO")
    private Double precoMinimo;

    @Column(name = "ESTOQUE_DISPONIVEL")
    private Double estoqueDisponivel;

    @Column(name = "ESTOQUE_FISICO")
    private Double estoqueFisico;

    @Column(name = "CONTROLA_ESTOQUE")
    private Boolean controlaEstoque;

    @Column(name = "PODE_ALTERAR_PRECO")
    private Boolean podeAlterarPreco;

    @Column(name = "PODE_ALTERAR_DESCRICAO")
    private Boolean podeAlterarDescricao;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "EMPRESA")
    private Long empresa;

    @Column(name = "VERSAO")
    private LocalDateTime versao;


    public ItemEntity(ItemDto dadosItem) {
        this.dataCadastro = LocalDateTime.now();
        this.tipo = dadosItem.tipo();
        this.perfilFiscal = dadosItem.perfilFiscal() != null ?
                new PerfilFiscalEntity(dadosItem.perfilFiscal()) : null;
        this.grupoItem = dadosItem.grupoItem() != null ?
                new ItemGrupoEntity(dadosItem.grupoItem()) : null;
        this.descricao = dadosItem.descricao();
        this.observacao = dadosItem.observacao();
        this.unidadeVenda = dadosItem.unidadeVenda() != null ?
                new UnidadeMedidaEntity(dadosItem.unidadeVenda()) : null;
        this.unidadeCompra = dadosItem.unidadeCompra() != null ?
                new UnidadeMedidaEntity(dadosItem.unidadeCompra()) : null;
        this.unidadeCompraFator = dadosItem.unidadeCompraFator();
        this.fabricante = dadosItem.fabricante() != null ?
                new FabricanteEntity(dadosItem.fabricante()) : null;
        this.origem = dadosItem.origem();
        this.ncm = dadosItem.ncm();
        this.cest = dadosItem.cest();
        this.codigoBarras = dadosItem.codigoBarras();
        this.codigoOriginal = dadosItem.codigoOriginal();
        this.tipoMovimentacao = dadosItem.tipoMovimentacao();
        this.precoCusto = dadosItem.precoCusto();
        this.precoVenda = dadosItem.precoVenda();
        this.margemLucro = dadosItem.margemLucro();
        this.precoMinimo = dadosItem.precoMinimo();
        this.estoqueDisponivel = dadosItem.estoqueDisponivel();
        this.estoqueFisico = dadosItem.estoqueFisico();
        this.controlaEstoque = dadosItem.controlaEstoque();
        this.podeAlterarPreco = dadosItem.podeAlterarPreco();
        this.podeAlterarDescricao = dadosItem.podeAlterarDescricao();
        this.status = dadosItem.status();
        this.empresa = dadosItem.empresa();
        this.versao = LocalDateTime.now();
    }

    public ItemEntity(NewItemDto item) {
        super();
    }

    public void atualizarItem(ItemDto dadosItem) {
        if (dadosItem.tipo() != null) {
            this.tipo = dadosItem.tipo();
        }
        if (dadosItem.perfilFiscal() != null) {
            this.perfilFiscal = new PerfilFiscalEntity(dadosItem.perfilFiscal());
        }
        if (dadosItem.grupoItem() != null) {
            this.grupoItem = new ItemGrupoEntity(dadosItem.grupoItem());
        }
        if (dadosItem.descricao() != null) {
            this.descricao = dadosItem.descricao();
        }
        if (dadosItem.observacao() != null) {
            this.observacao = dadosItem.observacao();
        }
        if (dadosItem.unidadeVenda() != null) {
            this.unidadeVenda = new UnidadeMedidaEntity(dadosItem.unidadeVenda());
        }
        if (dadosItem.unidadeCompra() != null) {
            this.unidadeCompra = new UnidadeMedidaEntity(dadosItem.unidadeCompra());
        }
        if (dadosItem.unidadeCompraFator() != null) {
            this.unidadeCompraFator = dadosItem.unidadeCompraFator();
        }
        if (dadosItem.fabricante() != null) {
            this.fabricante = new FabricanteEntity(dadosItem.fabricante());
        }
        if (dadosItem.origem() != null) {
            this.origem = dadosItem.origem();
        }
        if (dadosItem.ncm() != null) {
            this.ncm = dadosItem.ncm();
        }
        if (dadosItem.cest() != null) {
            this.cest = dadosItem.cest();
        }
        if (dadosItem.codigoBarras() != null) {
            this.codigoBarras = dadosItem.codigoBarras();
        }
        if (dadosItem.codigoOriginal() != null) {
            this.codigoOriginal = dadosItem.codigoOriginal();
        }
        if (dadosItem.tipoMovimentacao() != null) {
            this.tipoMovimentacao = dadosItem.tipoMovimentacao();
        }
        if (dadosItem.precoCusto() != null) {
            this.precoCusto = dadosItem.precoCusto();
        }
        if (dadosItem.precoVenda() != null) {
            this.precoVenda = dadosItem.precoVenda();
        }
        if (dadosItem.margemLucro() != null) {
            this.margemLucro = dadosItem.margemLucro();
        }
        if (dadosItem.precoMinimo() != null) {
            this.precoMinimo = dadosItem.precoMinimo();
        }
        if (dadosItem.estoqueDisponivel() != null) {
            this.estoqueDisponivel = dadosItem.estoqueDisponivel();
        }
        if (dadosItem.estoqueFisico() != null) {
            this.estoqueFisico = dadosItem.estoqueFisico();
        }
        if (dadosItem.controlaEstoque() != null) {
            this.controlaEstoque = dadosItem.controlaEstoque();
        }
        if (dadosItem.podeAlterarPreco() != null) {
            this.podeAlterarPreco = dadosItem.podeAlterarPreco();
        }
        if (dadosItem.podeAlterarDescricao() != null) {
            this.podeAlterarDescricao = dadosItem.podeAlterarDescricao();
        }
        if (dadosItem.status() != null) {
            this.status = dadosItem.status();
        }
        if (dadosItem.empresa() != null) {
            this.empresa = dadosItem.empresa();
        }
        this.versao = LocalDateTime.now();
    }

    public void setStatusAtivo() {
        this.status = Status.ATIVO;
    }

    public void setStatusInativo() {
        this.status = Status.DESATIVADO;
    }

}
