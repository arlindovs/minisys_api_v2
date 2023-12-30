package com.learning.api.minisys.controllers.cadastro.integrante;

import com.learning.api.minisys.dtos.cadastro.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.cadastro.integrante.IntegranteEntity;
import com.learning.api.minisys.enums.Status;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteGrupoRepository;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
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
@RequestMapping("/api/v1/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private IntegranteGrupoRepository integranteGrupoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarIntegrante(@RequestBody @Valid IntegranteDto integranteDto) {
        IntegranteEntity integranteEntity = new IntegranteEntity(integranteDto);

        if (integranteDto.integranteGrupo() != null) {
            integranteGrupoRepository.findById(integranteDto.integranteGrupo().getCODIGO())
                    .ifPresent(integranteEntity::setIntegranteGrupo);
        }

        integranteRepository.save(integranteEntity);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<IntegranteDto> listarIntegrantes() {
        return integranteRepository.findAll().stream().map(IntegranteDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<IntegranteDto> buscarIntegrante(@PathVariable Long CODIGO) {
        var integrante = integranteRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new IntegranteDto(integrante));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<IntegranteDto> atualizarIntegrante(@RequestBody @Valid IntegranteDto integranteDto) {
        // Busca a entidade existente no banco de dados
        IntegranteEntity integrante = integranteRepository.findById(integranteDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Integrante não encontrado"));

        // Atualiza os dados da entidade existente com base nos dados recebidos no DTO
        integrante.atualizarIntegrante(integranteDto);

        // Verifica se há um grupo associado ao integrante no DTO
        if (integranteDto.integranteGrupo() != null) {
            // Associa o integrante ao grupo, se fornecido no DTO
            integranteGrupoRepository.findById(integranteDto.integranteGrupo().getCODIGO())
                    .ifPresent(integrante::setIntegranteGrupo);
        } else {
            // Se o grupo for null no DTO, desassocia o integrante do grupo
            integrante.setIntegranteGrupo(null);
        }

        // Salva as alterações no banco de dados
        integranteRepository.save(integrante);

        // Retorna a resposta com o DTO atualizado
        return ResponseEntity.ok(new IntegranteDto(integrante));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarIntegrante(@PathVariable Long CODIGO) {
        integranteRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/desativar/{CODIGO}")
    @Transactional
    public ResponseEntity<IntegranteDto> ativarIntegrante(@PathVariable Long CODIGO) {
        var integrante = integranteRepository.getReferenceById(CODIGO);

        if (integrante.getStatus().equals(Status.ATIVO)) {
            integrante.setStatusInativo();
        } else {
            integrante.setStatusAtivo();
        }

        return ResponseEntity.ok(new IntegranteDto(integrante));
    }

}