package com.learning.api.minisys.repositories.faturamento.ordem_servico;

import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoEquipamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemServicoEquipamentoRepository extends JpaRepository<OrdemServicoEquipamentoEntity, Long> {
}
