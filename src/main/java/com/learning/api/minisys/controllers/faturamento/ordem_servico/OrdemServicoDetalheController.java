package com.learning.api.minisys.controllers.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.faturamento.ordem_servico.OrdemServicoDetalheDto;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoDetalheEntity;
import com.learning.api.minisys.repositories.cadastro.item.ItemRepository;
import com.learning.api.minisys.repositories.cadastro.item.UnidadeMedidaRepository;
import com.learning.api.minisys.repositories.faturamento.ordem_servico.OrdemServicoDetalheRepository;
import com.learning.api.minisys.repositories.faturamento.ordem_servico.OrdemServicoRepository;
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
@RequestMapping("/api/v1/ordem_servico_detalhes")
public class OrdemServicoDetalheController {

    @Autowired
    private OrdemServicoDetalheRepository ordemServicoDetalheRepository;
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarOrdemServicoDetalhe(@RequestBody @Valid OrdemServicoDetalheDto ordemServicoDetalheDto) {
        OrdemServicoDetalheEntity ordemServicoDetalheEntity = new OrdemServicoDetalheEntity(ordemServicoDetalheDto);

        if (ordemServicoDetalheDto.ordemServico() != null) {
            ordemServicoRepository.findById(ordemServicoDetalheDto.ordemServico().getCODIGO())
                    .ifPresent(ordemServicoDetalheEntity::setOrdemServico);
        }

        if (ordemServicoDetalheDto.item() != null) {
            itemRepository.findById(ordemServicoDetalheDto.item().getCODIGO())
                    .ifPresent(ordemServicoDetalheEntity::setItem);
        }

        if (ordemServicoDetalheDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(ordemServicoDetalheDto.unidadeMedida().getCODIGO())
                    .ifPresent(ordemServicoDetalheEntity::setUnidadeMedida);
        }

        ordemServicoDetalheRepository.save(ordemServicoDetalheEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<OrdemServicoDetalheDto> listarOrdemServicoDetalhes() {
        return ordemServicoDetalheRepository.findAll().stream().map(OrdemServicoDetalheDto::new).toList();
    }

    @GetMapping("/{CDOGIO}")
    public ResponseEntity<OrdemServicoDetalheDto> buscarOrdemServicoDetalhePorId(Long CODIGO) {
        var ordemServicoDetalhe = ordemServicoDetalheRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new OrdemServicoDetalheDto(ordemServicoDetalhe));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<OrdemServicoDetalheDto> atualizarOrdemServicoDetalhe(@RequestBody @Valid OrdemServicoDetalheDto ordemServicoDetalheDto) {
        OrdemServicoDetalheEntity ordemServicoDetalhe = ordemServicoDetalheRepository.findById(ordemServicoDetalheDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Ordem de Serviço Detalhe não encontrada"));

        ordemServicoDetalhe.atualizarOrdemServicoDetalhe(ordemServicoDetalheDto);

        if (ordemServicoDetalheDto.ordemServico() != null) {
            ordemServicoRepository.findById(ordemServicoDetalheDto.ordemServico().getCODIGO())
                    .ifPresent(ordemServicoDetalhe::setOrdemServico);
        } else {
            ordemServicoDetalhe.setOrdemServico(null);
        }

        if (ordemServicoDetalheDto.item() != null) {
            itemRepository.findById(ordemServicoDetalheDto.item().getCODIGO())
                    .ifPresent(ordemServicoDetalhe::setItem);
        } else {
            ordemServicoDetalhe.setItem(null);
        }

        if (ordemServicoDetalheDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(ordemServicoDetalheDto.unidadeMedida().getCODIGO())
                    .ifPresent(ordemServicoDetalhe::setUnidadeMedida);
        } else {
            ordemServicoDetalhe.setUnidadeMedida(null);
        }

        ordemServicoDetalheRepository.save(ordemServicoDetalhe);

        return ResponseEntity.ok(new OrdemServicoDetalheDto(ordemServicoDetalhe));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarOrdemServicoDetalhe(Long CODIGO) {
        var ordemServicoDetalhe = ordemServicoDetalheRepository.getReferenceById(CODIGO);

        if (ordemServicoDetalhe.getCancelado().equals(true)) {
            ordemServicoDetalhe.setCancelado(false);
        } else {
            ordemServicoDetalhe.setCancelado(true);
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarOrdemServicoDetalhe(Long CODIGO) {
        ordemServicoDetalheRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }

}
