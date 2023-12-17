package com.learning.api.minisys.controllers.faturamento.pedido;

import com.learning.api.minisys.dtos.faturamento.pedido.PedidoDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.faturamento.pedido.PedidoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
import com.learning.api.minisys.repositories.faturamento.pedido.PedidoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarPedido(@RequestBody @Valid PedidoDto pedidoDto) {
        PedidoEntity pedidoEntity = new PedidoEntity(pedidoDto);

        if (pedidoDto.integrante() != null) {
            integranteRepository.findById(pedidoDto.integrante().getCODIGO())
                    .ifPresent(pedidoEntity::setIntegrante);
        }

        pedidoRepository.save(pedidoEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<PedidoDto> listarPedidos() {
        return pedidoRepository.findAll().stream().map(PedidoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<PedidoDto> buscarPedido(Long CODIGO) {
        var pedido = pedidoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new PedidoDto(pedido));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PedidoDto> atualizarPedido(@RequestBody @Valid PedidoDto pedidoDto) {
        PedidoEntity pedido = pedidoRepository.findById(pedidoDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.atualizarPedido(pedidoDto);

        if (pedidoDto.integrante() != null) {
            IntegranteEntity integrante = integranteRepository.findById(pedidoDto.integrante().getCODIGO())
                    .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));

            pedido.setIntegrante(integrante);
        } else {
            pedido.setIntegrante(null);
        }

        pedidoRepository.save(pedido);

        return ResponseEntity.ok(new PedidoDto(pedido));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long CODIGO) {
        var pedido = pedidoRepository.getReferenceById(CODIGO);

        if (pedido.getStatus().equals(Status.NORMAL)) {
            pedido.setStatusCancelado();
        } else {
            pedido.setStatusNormal();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarPedido(@PathVariable Long CODIGO) {
        pedidoRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
