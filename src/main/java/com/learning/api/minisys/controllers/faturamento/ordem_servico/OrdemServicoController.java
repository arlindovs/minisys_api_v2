package com.learning.api.minisys.controllers.faturamento.ordem_servico;

import com.learning.api.minisys.dtos.faturamento.ordem_servico.OrdemServicoDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.faturamento.ordem_servico.OrdemServicoEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
import com.learning.api.minisys.repositories.faturamento.ordem_servico.OrdemServicoRepository;
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
@RequestMapping("/api/v1/ordens_servico")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarOrdemServico(@RequestBody @Valid OrdemServicoDto ordemServicoDto) {
        OrdemServicoEntity ordemServicoEntity = new OrdemServicoEntity(ordemServicoDto);

        if (ordemServicoDto.integrante() != null) {
            integranteRepository.findById(ordemServicoDto.integrante().getCODIGO())
                    .ifPresent(ordemServicoEntity::setIntegrante);
        }

        ordemServicoRepository.save(ordemServicoEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<OrdemServicoDto> listarOrdensServico() {
        return ordemServicoRepository.findAll().stream().map(OrdemServicoDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<OrdemServicoDto> buscarOrdemServico(Long CODIGO) {
        var ordemServico = ordemServicoRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new OrdemServicoDto(ordemServico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<OrdemServicoDto> atualizarOrdemServico(@RequestBody @Valid OrdemServicoDto ordemServicoDto) {
        OrdemServicoEntity ordemServico = ordemServicoRepository.findById(ordemServicoDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Ordem de Serviço não encontrada"));

        ordemServico.atualizarOrdemServico(ordemServicoDto);

        if (ordemServicoDto.integrante() != null) {
            IntegranteEntity integrante = integranteRepository.findById(ordemServicoDto.integrante().getCODIGO())
                    .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));

            ordemServico.setIntegrante(integrante);
        } else {
            ordemServico.setIntegrante(null);
        }

        ordemServicoRepository.save(ordemServico);

        return ResponseEntity.ok(new OrdemServicoDto(ordemServico));
    }

    @PostMapping("/cancelar/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> cancelarOrdemServico(@PathVariable Long CODIGO) {
        var ordemServico = ordemServicoRepository.getReferenceById(CODIGO);

        if (ordemServico.getStatus().equals(Status.NORMAL)) {
            ordemServico.setStatus(Status.CANCELADO);
        } else {
            ordemServico.setStatus(Status.NORMAL);
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarOrdemServico(@PathVariable Long CODIGO) {
       ordemServicoRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
