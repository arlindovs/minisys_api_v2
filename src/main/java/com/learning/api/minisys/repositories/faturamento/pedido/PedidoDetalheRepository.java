package com.learning.api.minisys.repositories.faturamento.pedido;

import com.learning.api.minisys.entitys.faturamento.pedido.PedidoDetalheEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDetalheRepository extends JpaRepository<PedidoDetalheEntity, Long> {
}
