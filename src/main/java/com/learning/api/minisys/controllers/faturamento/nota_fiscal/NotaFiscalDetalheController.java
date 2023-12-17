package com.learning.api.minisys.controllers.faturamento.nota_fiscal;

import com.learning.api.minisys.dtos.faturamento.nota_fiscal.NotaFiscalDetalheDto;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalDetalheEntity;
import com.learning.api.minisys.repositories.cadastro.item.ItemRepository;
import com.learning.api.minisys.repositories.cadastro.item.UnidadeMedidaRepository;
import com.learning.api.minisys.repositories.faturamento.nota_fiscal.NotaFiscalDetalheRepository;
import com.learning.api.minisys.repositories.faturamento.nota_fiscal.NotaFiscalRepository;
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
@RequestMapping("/api/v1/nota_fiscal_detalhes")
public class NotaFiscalDetalheController {

    @Autowired
    private NotaFiscalDetalheRepository notaFiscalDetalheRepository;
    @Autowired
    private NotaFiscalRepository notaFiscalRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarNotaFiscalDetalhe(@RequestBody @Valid NotaFiscalDetalheDto notaFiscalDetalheDto) {
        NotaFiscalDetalheEntity notaFiscalDetalheEntity = new NotaFiscalDetalheEntity(notaFiscalDetalheDto);

        if (notaFiscalDetalheDto.notaFiscal() != null) {
            notaFiscalRepository.findById(notaFiscalDetalheDto.notaFiscal().getCODIGO())
                    .ifPresent(notaFiscalDetalheEntity::setNotaFiscal);
        }

        if (notaFiscalDetalheDto.item() != null) {
            itemRepository.findById(notaFiscalDetalheDto.item().getCODIGO())
                    .ifPresent(notaFiscalDetalheEntity::setItem);
        }

        if (notaFiscalDetalheDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(notaFiscalDetalheDto.unidadeMedida().getCODIGO())
                    .ifPresent(notaFiscalDetalheEntity::setUnidadeMedida);
        }

        notaFiscalDetalheRepository.save(notaFiscalDetalheEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<NotaFiscalDetalheEntity>> listarNotaFiscalDetalhes() {
        return ResponseEntity.ok(notaFiscalDetalheRepository.findAll());
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<NotaFiscalDetalheDto> buscarNotaFiscalDetalhe(Long CODIGO) {
        var notaFiscalDetalhe = notaFiscalDetalheRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new NotaFiscalDetalheDto(notaFiscalDetalhe));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<NotaFiscalDetalheDto> atualizarNotaFiscalDetalhe(@RequestBody @Valid NotaFiscalDetalheDto notaFiscalDetalheDto) {
        NotaFiscalDetalheEntity notaFiscalDetalhe = notaFiscalDetalheRepository.findById(notaFiscalDetalheDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Nota Fiscal Detalhe não encontrado"));

        notaFiscalDetalhe.atualizarNotaFiscalDetalhe(notaFiscalDetalheDto);

        if (notaFiscalDetalheDto.notaFiscal() != null) {
            notaFiscalRepository.findById(notaFiscalDetalheDto.notaFiscal().getCODIGO())
                    .ifPresent(notaFiscalDetalhe::setNotaFiscal);
        } else {
            notaFiscalDetalhe.setNotaFiscal(null);
        }

        if (notaFiscalDetalheDto.item() != null) {
            itemRepository.findById(notaFiscalDetalheDto.item().getCODIGO())
                    .ifPresent(notaFiscalDetalhe::setItem);
        } else {
            notaFiscalDetalhe.setItem(null);
        }

        if (notaFiscalDetalheDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(notaFiscalDetalheDto.unidadeMedida().getCODIGO())
                    .ifPresent(notaFiscalDetalhe::setUnidadeMedida);
        } else {
            notaFiscalDetalhe.setUnidadeMedida(null);
        }

        notaFiscalDetalheRepository.save(notaFiscalDetalhe);

        return ResponseEntity.ok(new NotaFiscalDetalheDto(notaFiscalDetalhe));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarNotaFiscalDetalhe(Long CODIGO) {
        var notaFiscalDetalhe = notaFiscalDetalheRepository.getReferenceById(CODIGO);

        if (notaFiscalDetalhe.getCancelado().equals(true)) {
            notaFiscalDetalhe.setCancelado(false);
        } else {
            notaFiscalDetalhe.setCancelado(true);
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarNotaFiscalDetalhe(Long CODIGO) {
        notaFiscalDetalheRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
