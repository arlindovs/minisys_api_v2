package com.learning.api.minisys.controllers.faturamento.pedido;

import com.learning.api.minisys.dtos.faturamento.pedido.PedidoDetalheDto;
import com.learning.api.minisys.entitys.faturamento.pedido.PedidoDetalheEntity;
import com.learning.api.minisys.repositories.cadastro.item.ItemRepository;
import com.learning.api.minisys.repositories.cadastro.item.UnidadeMedidaRepository;
import com.learning.api.minisys.repositories.faturamento.pedido.PedidoDetalheRepository;
import com.learning.api.minisys.repositories.faturamento.pedido.PedidoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedido_detalhes")
public class PedidoDetalheController {

    @Autowired
    private PedidoDetalheRepository pedidoDetalheRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarPedidoDetalhe(@RequestBody @Valid PedidoDetalheDto pedidoDetalheDto) {
        PedidoDetalheEntity pedidoDetalheEntity = new PedidoDetalheEntity(pedidoDetalheDto);

        if (pedidoDetalheDto.pedido() != null) {
            pedidoRepository.findById(pedidoDetalheDto.pedido().getCODIGO())
                    .ifPresent(pedidoDetalheEntity::setPedido);
        }

        if (pedidoDetalheDto.item() != null) {
            itemRepository.findById(pedidoDetalheDto.item().getCODIGO())
                    .ifPresent(pedidoDetalheEntity::setItem);
        }

        if (pedidoDetalheDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(pedidoDetalheDto.unidadeMedida().getCODIGO())
                    .ifPresent(pedidoDetalheEntity::setUnidadeMedida);
        }

        pedidoDetalheRepository.save(pedidoDetalheEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<PedidoDetalheDto> listarPedidoDetalhes() {
        return pedidoDetalheRepository.findAll().stream().map(PedidoDetalheDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<PedidoDetalheDto> buscarPedidoDetalhe(Long CODIGO) {
        var pedidoDetalhe = pedidoDetalheRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new PedidoDetalheDto(pedidoDetalhe));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PedidoDetalheDto> atualizarPedidoDetalhe(@RequestBody @Valid PedidoDetalheDto pedidoDetalheDto) {
        PedidoDetalheEntity pedidoDetalhe = pedidoDetalheRepository.findById(pedidoDetalheDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Pedido Detalhe não encontrado"));

        pedidoDetalhe.atualizarPedidoDetalhe(pedidoDetalheDto);

        if (pedidoDetalheDto.pedido() != null) {
            pedidoRepository.findById(pedidoDetalheDto.pedido().getCODIGO())
                    .ifPresent(pedidoDetalhe::setPedido);
        } else {
            pedidoDetalhe.setPedido(null);
        }

        if (pedidoDetalheDto.item() != null) {
            itemRepository.findById(pedidoDetalheDto.item().getCODIGO())
                    .ifPresent(pedidoDetalhe::setItem);
        } else {
            pedidoDetalhe.setItem(null);
        }

        if (pedidoDetalheDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(pedidoDetalheDto.unidadeMedida().getCODIGO())
                    .ifPresent(pedidoDetalhe::setUnidadeMedida);
        } else {
            pedidoDetalhe.setUnidadeMedida(null);
        }

        pedidoDetalheRepository.save(pedidoDetalhe);

        return ResponseEntity.ok(new PedidoDetalheDto(pedidoDetalhe));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarPedidoDetalhe(Long CODIGO) {
        var pedidoDetalhe = pedidoDetalheRepository.getReferenceById(CODIGO);

        if (pedidoDetalhe.getCancelado().equals(true)) {
            pedidoDetalhe.setCancelado(false);
        } else {
            pedidoDetalhe.setCancelado(true);
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarPedidoDetalhe(Long CODIGO) {
        pedidoDetalheRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
