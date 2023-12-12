package com.learning.api.minisys.controllers.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.repositories.integrante.IntegranteGrupoRepository;
import com.learning.api.minisys.repositories.integrante.IntegranteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
            Optional<IntegranteGrupoEntity> integranteGrupoEntity = integranteGrupoRepository.findById(integranteDto.integranteGrupo().getCODIGO());

            if (integranteGrupoEntity.isPresent()) {
                integranteEntity.setIntegranteGrupo(integranteGrupoEntity.get());
            }
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
            Optional<IntegranteGrupoEntity> integranteGrupoEntity = integranteGrupoRepository.findById(integranteDto.integranteGrupo().getCODIGO());

            if (integranteGrupoEntity.isPresent()) {
                integrante.setIntegranteGrupo(integranteGrupoEntity.get());
            } else {
                // Tratar o caso em que o grupo no DTO não foi encontrado no banco de dados
                // Você pode optar por lançar uma exceção, logar um aviso, ou tomar outra ação apropriada
            }
        } else {
            // Se o grupo for null no DTO, desassocie o integrante do grupo
            integrante.setIntegranteGrupo(null);
        }

        // Salva as alterações no banco de dados
        integranteRepository.save(integrante);

        return ResponseEntity.ok(new IntegranteDto(integrante));
    }




}