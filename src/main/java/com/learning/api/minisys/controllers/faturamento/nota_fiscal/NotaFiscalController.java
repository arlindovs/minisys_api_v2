package com.learning.api.minisys.controllers.faturamento.nota_fiscal;

import com.learning.api.minisys.dtos.faturamento.nota_fiscal.NotaFiscalDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.faturamento.nota_fiscal.NotaFiscalEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
import com.learning.api.minisys.repositories.faturamento.nota_fiscal.NotaFiscalRepository;
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
@RequestMapping("/api/v1/notas_fiscais")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;
    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarNotaFiscal(@RequestBody @Valid NotaFiscalDto notaFiscalDto) {
        NotaFiscalEntity notaFiscalEntity = new NotaFiscalEntity(notaFiscalDto);

        if (notaFiscalDto.integrante() != null) {
            integranteRepository.findById(notaFiscalDto.integrante().getCODIGO())
                    .ifPresent(notaFiscalEntity::setIntegrante);
        }

        notaFiscalRepository.save(notaFiscalEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<NotaFiscalDto> listarNotasFiscais() {
        return notaFiscalRepository.findAll().stream().map(NotaFiscalDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<NotaFiscalDto> buscarNotaFiscal(Long CODIGO) {
        var notaFiscal = notaFiscalRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new NotaFiscalDto(notaFiscal));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<NotaFiscalDto> atualizarNotaFiscal(@RequestBody @Valid NotaFiscalDto notaFiscalDto) {
        NotaFiscalEntity notaFiscal = notaFiscalRepository.findById(notaFiscalDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Nota Fiscal não encontrada"));

        notaFiscal.atualizarNotaFiscal(notaFiscalDto);

        if (notaFiscalDto.integrante() != null) {
            IntegranteEntity integrante = integranteRepository.findById(notaFiscalDto.integrante().getCODIGO())
                    .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));

            notaFiscal.setIntegrante(integrante);
        } else {
            notaFiscal.setIntegrante(null);
        }

        notaFiscalRepository.save(notaFiscal);

        return ResponseEntity.ok(new NotaFiscalDto(notaFiscal));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarNotaFiscal(@PathVariable Long CODIGO) {
        var notaFiscal = notaFiscalRepository.getReferenceById(CODIGO);

        if (notaFiscal.getStatus().equals(Status.NORMAL)) {
            notaFiscal.setStatusCancelado();
        } else {
            notaFiscal.setStatusNormal();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarNotaFiscal(@PathVariable Long CODIGO) {
        notaFiscalRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
