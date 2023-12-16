package com.learning.api.minisys.repositories.faturamento.pedido;

import com.learning.api.minisys.entitys.faturamento.pedido.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
