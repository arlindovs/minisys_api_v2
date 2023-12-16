package com.learning.api.minisys.entitys.faturamento.ordem_servico;

import com.learning.api.minisys.entitys.BaseEntity;
import com.learning.api.minisys.enums.ordem_servico.FinalidadeOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.StatusOrdemServico;
import com.learning.api.minisys.enums.ordem_servico.TipoMovimentacaoOrdem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ordem_servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoEntity extends BaseEntity {

    @Column(name = "TIPO_MOVIMENTACAO")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacaoOrdem tipoMovimentacao;

    @Column(name = "FINALIDADE")
    @Enumerated(EnumType.STRING)
    private FinalidadeOrdemServico finalidade;

    @Column(name = "STATUS_ORDEM")
    @Enumerated(EnumType.STRING)
    private StatusOrdemServico statusOrdem;
}
