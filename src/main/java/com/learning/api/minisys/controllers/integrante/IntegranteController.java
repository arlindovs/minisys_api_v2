package com.learning.api.minisys.controllers.integrante;

import com.learning.api.minisys.dtos.integrante.IntegranteDto;
import com.learning.api.minisys.entitys.integrante.IntegranteEntity;
import com.learning.api.minisys.entitys.integrante.IntegranteGrupoEntity;
import com.learning.api.minisys.repositories.integrante.IntegranteGrupoRepository;
import com.learning.api.minisys.repositories.integrante.IntegranteRepository;
import com.learning.api.minisys.services.integrante.IntegranteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;

    @Autowired
    private IntegranteGrupoRepository integranteGrupoRepository;

    @Autowired
    private IntegranteService integranteService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarIntegrante(@RequestBody @Valid IntegranteDto integranteDto) {
        IntegranteEntity integranteEntity = new IntegranteEntity(integranteDto);

        if (integranteDto.integranteGrupo() != null) {
            Optional<IntegranteGrupoEntity> integranteGrupoEntity = integranteGrupoRepository.findByGuid(integranteDto.integranteGrupo().guid());

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

    @PutMapping("/{guid}")
    public ResponseEntity<IntegranteDto> atualizarIntegrante(@PathVariable String guid, @RequestBody @Valid IntegranteDto integranteDto) {
        IntegranteDto updatedIntegrante = integranteService.updateIntegrante(guid, integranteDto);
        return new ResponseEntity<>(updatedIntegrante, HttpStatus.OK);
    }


}