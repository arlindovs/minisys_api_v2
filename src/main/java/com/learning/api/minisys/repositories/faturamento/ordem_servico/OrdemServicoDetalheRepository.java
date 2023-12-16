package com.learning.api.minisys.repositories.faturamento.ordem_servico;

import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoDetalheRepository extends JpaRepository<OrdemServicoDetalheEntity, Long> {
}
