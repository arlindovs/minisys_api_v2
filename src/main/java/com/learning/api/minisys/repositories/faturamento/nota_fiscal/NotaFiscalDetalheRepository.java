package com.learning.api.minisys.repositories.faturamento.nota_fiscal;

import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalDetalheRepository extends JpaRepository<NotaFiscalDetalheEntity, Long> {
}
