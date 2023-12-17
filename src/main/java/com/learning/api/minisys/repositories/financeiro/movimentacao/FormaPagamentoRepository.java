package com.learning.api.minisys.repositories.financeiro.movimentacao;

import com.learning.api.minisys.entitys.financeiro.movimentacao.FormaPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamentoEntity, Long> {
}
