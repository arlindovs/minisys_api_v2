package com.learning.api.minisys.repositories.faturamento.ordem_servico;

import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoRepository extends JpaRepository<OrdemServicoEntity, Long> {
}
