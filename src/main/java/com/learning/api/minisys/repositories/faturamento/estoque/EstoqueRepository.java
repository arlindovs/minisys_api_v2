package com.learning.api.minisys.repositories.faturamento.estoque;

import com.learning.api.minisys.entitys.faturamento.estoque.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {
}
