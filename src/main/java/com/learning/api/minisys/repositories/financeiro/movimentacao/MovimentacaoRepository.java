package com.learning.api.minisys.repositories.financeiro.movimentacao;

import com.learning.api.minisys.entitys.financeiro.movimentacao.MovimentacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoEntity, Long> {
}
